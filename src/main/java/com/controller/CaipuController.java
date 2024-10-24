
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 菜谱
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caipu")
public class CaipuController {
    private static final Logger logger = LoggerFactory.getLogger(CaipuController.class);

    private static final String TABLE_NAME = "caipu";

    @Autowired
    private CaipuService caipuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = caipuService.queryPage(params);

        //字典表数据转换
        List<CaipuView> list =(List<CaipuView>)page.getList();
        for(CaipuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CaipuEntity caipu = caipuService.selectById(id);
        if(caipu !=null){
            //entity转view
            CaipuView view = new CaipuView();
            BeanUtils.copyProperties( caipu , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CaipuEntity caipu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caipu:{}",this.getClass().getName(),caipu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CaipuEntity> queryWrapper = new EntityWrapper<CaipuEntity>()
            .eq("caipu_name", caipu.getCaipuName())
            .eq("caipu_weizhi", caipu.getCaipuWeizhi())
            .eq("caipu_video", caipu.getCaipuVideo())
            .eq("caipu_types", caipu.getCaipuTypes())
            .eq("caipu_kouwei_types", caipu.getCaipuKouweiTypes())
            .eq("caipu_clicknum", caipu.getCaipuClicknum())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaipuEntity caipuEntity = caipuService.selectOne(queryWrapper);
        if(caipuEntity==null){
            caipu.setCaipuClicknum(1);
            caipu.setInsertTime(new Date());
            caipu.setCreateTime(new Date());
            caipuService.insert(caipu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaipuEntity caipu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,caipu:{}",this.getClass().getName(),caipu.toString());
        CaipuEntity oldCaipuEntity = caipuService.selectById(caipu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(caipu.getCaipuPhoto()) || "null".equals(caipu.getCaipuPhoto())){
                caipu.setCaipuPhoto(null);
        }
        if("".equals(caipu.getCaipuVideo()) || "null".equals(caipu.getCaipuVideo())){
                caipu.setCaipuVideo(null);
        }

            caipuService.updateById(caipu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CaipuEntity> oldCaipuList =caipuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        caipuService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<CaipuEntity> caipuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            CaipuEntity caipuEntity = new CaipuEntity();
//                            caipuEntity.setCaipuName(data.get(0));                    //菜谱名称 要改的
//                            caipuEntity.setCaipuUuidNumber(data.get(0));                    //菜谱编号 要改的
//                            caipuEntity.setCaipuPhoto("");//详情和图片
//                            caipuEntity.setCaipuWeizhi(data.get(0));                    //小店位置 要改的
//                            caipuEntity.setCaipuVideo(data.get(0));                    //视频推荐 要改的
//                            caipuEntity.setCaipuJiage(data.get(0));                    //菜品价格 要改的
//                            caipuEntity.setCaipuTypes(Integer.valueOf(data.get(0)));   //菜谱类型 要改的
//                            caipuEntity.setCaipuKouweiTypes(Integer.valueOf(data.get(0)));   //口味 要改的
//                            caipuEntity.setCaipuClicknum(Integer.valueOf(data.get(0)));   //菜谱热度 要改的
//                            caipuEntity.setCaipuContent("");//详情和图片
//                            caipuEntity.setInsertTime(date);//时间
//                            caipuEntity.setCreateTime(date);//时间
                            caipuList.add(caipuEntity);


                            //把要查询是否重复的字段放入map中
                                //菜谱编号
                                if(seachFields.containsKey("caipuUuidNumber")){
                                    List<String> caipuUuidNumber = seachFields.get("caipuUuidNumber");
                                    caipuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> caipuUuidNumber = new ArrayList<>();
                                    caipuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("caipuUuidNumber",caipuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //菜谱编号
                        List<CaipuEntity> caipuEntities_caipuUuidNumber = caipuService.selectList(new EntityWrapper<CaipuEntity>().in("caipu_uuid_number", seachFields.get("caipuUuidNumber")));
                        if(caipuEntities_caipuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaipuEntity s:caipuEntities_caipuUuidNumber){
                                repeatFields.add(s.getCaipuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [菜谱编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        caipuService.insertBatch(caipuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = caipuService.queryPage(params);

        //字典表数据转换
        List<CaipuView> list =(List<CaipuView>)page.getList();
        for(CaipuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CaipuEntity caipu = caipuService.selectById(id);
            if(caipu !=null){

                //点击数量加1
                caipu.setCaipuClicknum(caipu.getCaipuClicknum()+1);
                caipuService.updateById(caipu);

                //entity转view
                CaipuView view = new CaipuView();
                BeanUtils.copyProperties( caipu , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody CaipuEntity caipu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,caipu:{}",this.getClass().getName(),caipu.toString());
        Wrapper<CaipuEntity> queryWrapper = new EntityWrapper<CaipuEntity>()
            .eq("caipu_name", caipu.getCaipuName())
            .eq("caipu_uuid_number", caipu.getCaipuUuidNumber())
            .eq("caipu_weizhi", caipu.getCaipuWeizhi())
            .eq("caipu_video", caipu.getCaipuVideo())
            .eq("caipu_types", caipu.getCaipuTypes())
            .eq("caipu_kouwei_types", caipu.getCaipuKouweiTypes())
            .eq("caipu_clicknum", caipu.getCaipuClicknum())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaipuEntity caipuEntity = caipuService.selectOne(queryWrapper);
        if(caipuEntity==null){
            caipu.setInsertTime(new Date());
            caipu.setCreateTime(new Date());
        caipuService.insert(caipu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
