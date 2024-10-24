package com.entity.model;

import com.entity.CaipuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 菜谱
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaipuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 菜谱名称
     */
    private String caipuName;


    /**
     * 菜谱编号
     */
    private String caipuUuidNumber;


    /**
     * 菜谱照片
     */
    private String caipuPhoto;


    /**
     * 小店位置
     */
    private String caipuWeizhi;


    /**
     * 视频推荐
     */
    private String caipuVideo;


    /**
     * 菜品价格
     */
    private Double caipuJiage;


    /**
     * 菜谱类型
     */
    private Integer caipuTypes;


    /**
     * 口味
     */
    private Integer caipuKouweiTypes;


    /**
     * 菜谱热度
     */
    private Integer caipuClicknum;


    /**
     * 菜品介绍
     */
    private String caipuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：菜谱名称
	 */
    public String getCaipuName() {
        return caipuName;
    }


    /**
	 * 设置：菜谱名称
	 */
    public void setCaipuName(String caipuName) {
        this.caipuName = caipuName;
    }
    /**
	 * 获取：菜谱编号
	 */
    public String getCaipuUuidNumber() {
        return caipuUuidNumber;
    }


    /**
	 * 设置：菜谱编号
	 */
    public void setCaipuUuidNumber(String caipuUuidNumber) {
        this.caipuUuidNumber = caipuUuidNumber;
    }
    /**
	 * 获取：菜谱照片
	 */
    public String getCaipuPhoto() {
        return caipuPhoto;
    }


    /**
	 * 设置：菜谱照片
	 */
    public void setCaipuPhoto(String caipuPhoto) {
        this.caipuPhoto = caipuPhoto;
    }
    /**
	 * 获取：小店位置
	 */
    public String getCaipuWeizhi() {
        return caipuWeizhi;
    }


    /**
	 * 设置：小店位置
	 */
    public void setCaipuWeizhi(String caipuWeizhi) {
        this.caipuWeizhi = caipuWeizhi;
    }
    /**
	 * 获取：视频推荐
	 */
    public String getCaipuVideo() {
        return caipuVideo;
    }


    /**
	 * 设置：视频推荐
	 */
    public void setCaipuVideo(String caipuVideo) {
        this.caipuVideo = caipuVideo;
    }
    /**
	 * 获取：菜品价格
	 */
    public Double getCaipuJiage() {
        return caipuJiage;
    }


    /**
	 * 设置：菜品价格
	 */
    public void setCaipuJiage(Double caipuJiage) {
        this.caipuJiage = caipuJiage;
    }
    /**
	 * 获取：菜谱类型
	 */
    public Integer getCaipuTypes() {
        return caipuTypes;
    }


    /**
	 * 设置：菜谱类型
	 */
    public void setCaipuTypes(Integer caipuTypes) {
        this.caipuTypes = caipuTypes;
    }
    /**
	 * 获取：口味
	 */
    public Integer getCaipuKouweiTypes() {
        return caipuKouweiTypes;
    }


    /**
	 * 设置：口味
	 */
    public void setCaipuKouweiTypes(Integer caipuKouweiTypes) {
        this.caipuKouweiTypes = caipuKouweiTypes;
    }
    /**
	 * 获取：菜谱热度
	 */
    public Integer getCaipuClicknum() {
        return caipuClicknum;
    }


    /**
	 * 设置：菜谱热度
	 */
    public void setCaipuClicknum(Integer caipuClicknum) {
        this.caipuClicknum = caipuClicknum;
    }
    /**
	 * 获取：菜品介绍
	 */
    public String getCaipuContent() {
        return caipuContent;
    }


    /**
	 * 设置：菜品介绍
	 */
    public void setCaipuContent(String caipuContent) {
        this.caipuContent = caipuContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
