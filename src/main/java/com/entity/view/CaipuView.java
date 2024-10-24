package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.CaipuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 菜谱
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("caipu")
public class CaipuView extends CaipuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 菜谱类型的值
	*/
	@ColumnInfo(comment="菜谱类型的字典表值",type="varchar(200)")
	private String caipuValue;
	/**
	* 口味的值
	*/
	@ColumnInfo(comment="口味的字典表值",type="varchar(200)")
	private String caipuKouweiValue;




	public CaipuView() {

	}

	public CaipuView(CaipuEntity caipuEntity) {
		try {
			BeanUtils.copyProperties(this, caipuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 菜谱类型的值
	*/
	public String getCaipuValue() {
		return caipuValue;
	}
	/**
	* 设置： 菜谱类型的值
	*/
	public void setCaipuValue(String caipuValue) {
		this.caipuValue = caipuValue;
	}
	//当前表的
	/**
	* 获取： 口味的值
	*/
	public String getCaipuKouweiValue() {
		return caipuKouweiValue;
	}
	/**
	* 设置： 口味的值
	*/
	public void setCaipuKouweiValue(String caipuKouweiValue) {
		this.caipuKouweiValue = caipuKouweiValue;
	}




	@Override
	public String toString() {
		return "CaipuView{" +
			", caipuValue=" + caipuValue +
			", caipuKouweiValue=" + caipuKouweiValue +
			"} " + super.toString();
	}
}
