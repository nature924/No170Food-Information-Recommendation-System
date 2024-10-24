package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.CaipuDao;
import com.entity.CaipuEntity;
import com.service.CaipuService;
import com.entity.view.CaipuView;

/**
 * 菜谱 服务实现类
 */
@Service("caipuService")
@Transactional
public class CaipuServiceImpl extends ServiceImpl<CaipuDao, CaipuEntity> implements CaipuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<CaipuView> page =new Query<CaipuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
