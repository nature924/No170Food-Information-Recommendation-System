package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 菜谱
 *
 * @author 
 * @email
 */
@TableName("caipu")
public class CaipuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CaipuEntity() {

	}

	public CaipuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 菜谱名称
     */
    @ColumnInfo(comment="菜谱名称",type="varchar(200)")
    @TableField(value = "caipu_name")

    private String caipuName;


    /**
     * 菜谱编号
     */
    @ColumnInfo(comment="菜谱编号",type="varchar(200)")
    @TableField(value = "caipu_uuid_number")

    private String caipuUuidNumber;


    /**
     * 菜谱照片
     */
    @ColumnInfo(comment="菜谱照片",type="varchar(200)")
    @TableField(value = "caipu_photo")

    private String caipuPhoto;


    /**
     * 小店位置
     */
    @ColumnInfo(comment="小店位置",type="varchar(200)")
    @TableField(value = "caipu_weizhi")

    private String caipuWeizhi;


    /**
     * 视频推荐
     */
    @ColumnInfo(comment="视频推荐",type="varchar(200)")
    @TableField(value = "caipu_video")

    private String caipuVideo;


    /**
     * 菜品价格
     */
    @ColumnInfo(comment="菜品价格",type="decimal(10,2)")
    @TableField(value = "caipu_jiage")

    private Double caipuJiage;


    /**
     * 菜谱类型
     */
    @ColumnInfo(comment="菜谱类型",type="int(11)")
    @TableField(value = "caipu_types")

    private Integer caipuTypes;


    /**
     * 口味
     */
    @ColumnInfo(comment="口味",type="int(11)")
    @TableField(value = "caipu_kouwei_types")

    private Integer caipuKouweiTypes;


    /**
     * 菜谱热度
     */
    @ColumnInfo(comment="菜谱热度",type="int(11)")
    @TableField(value = "caipu_clicknum")

    private Integer caipuClicknum;


    /**
     * 菜品介绍
     */
    @ColumnInfo(comment="菜品介绍",type="text")
    @TableField(value = "caipu_content")

    private String caipuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Caipu{" +
            ", id=" + id +
            ", caipuName=" + caipuName +
            ", caipuUuidNumber=" + caipuUuidNumber +
            ", caipuPhoto=" + caipuPhoto +
            ", caipuWeizhi=" + caipuWeizhi +
            ", caipuVideo=" + caipuVideo +
            ", caipuJiage=" + caipuJiage +
            ", caipuTypes=" + caipuTypes +
            ", caipuKouweiTypes=" + caipuKouweiTypes +
            ", caipuClicknum=" + caipuClicknum +
            ", caipuContent=" + caipuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
