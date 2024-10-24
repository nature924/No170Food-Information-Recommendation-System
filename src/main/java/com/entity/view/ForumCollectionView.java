package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ForumCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 论坛收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("forum_collection")
public class ForumCollectionView extends ForumCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String forumCollectionValue;

	//级联表 论坛
		/**
		* 帖子标题
		*/

		@ColumnInfo(comment="帖子标题",type="varchar(200)")
		private String forumName;
					 
		/**
		* 论坛 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer forumYonghuId;
					 
		/**
		* 论坛 的 管理员
		*/
		@ColumnInfo(comment="管理员",type="int(11)")
		private Integer forumUsersId;
		/**
		* 发布内容
		*/

		@ColumnInfo(comment="发布内容",type="text")
		private String forumContent;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 父id
		*/

		@ColumnInfo(comment="父id",type="int(11)")
		private Integer superIds;
		/**
		* 帖子状态
		*/
		@ColumnInfo(comment="帖子状态",type="int(11)")
		private Integer forumStateTypes;
			/**
			* 帖子状态的值
			*/
			@ColumnInfo(comment="帖子状态的字典表值",type="varchar(200)")
			private String forumStateValue;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;



	public ForumCollectionView() {

	}

	public ForumCollectionView(ForumCollectionEntity forumCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, forumCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getForumCollectionValue() {
		return forumCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setForumCollectionValue(String forumCollectionValue) {
		this.forumCollectionValue = forumCollectionValue;
	}


	//级联表的get和set 论坛

		/**
		* 获取： 帖子标题
		*/
		public String getForumName() {
			return forumName;
		}
		/**
		* 设置： 帖子标题
		*/
		public void setForumName(String forumName) {
			this.forumName = forumName;
		}
		/**
		* 获取：论坛 的 用户
		*/
		public Integer getForumYonghuId() {
			return forumYonghuId;
		}
		/**
		* 设置：论坛 的 用户
		*/
		public void setForumYonghuId(Integer forumYonghuId) {
			this.forumYonghuId = forumYonghuId;
		}
		/**
		* 获取：论坛 的 管理员
		*/
		public Integer getForumUsersId() {
			return forumUsersId;
		}
		/**
		* 设置：论坛 的 管理员
		*/
		public void setForumUsersId(Integer forumUsersId) {
			this.forumUsersId = forumUsersId;
		}

		/**
		* 获取： 发布内容
		*/
		public String getForumContent() {
			return forumContent;
		}
		/**
		* 设置： 发布内容
		*/
		public void setForumContent(String forumContent) {
			this.forumContent = forumContent;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 父id
		*/
		public Integer getSuperIds() {
			return superIds;
		}
		/**
		* 设置： 父id
		*/
		public void setSuperIds(Integer superIds) {
			this.superIds = superIds;
		}
		/**
		* 获取： 帖子状态
		*/
		public Integer getForumStateTypes() {
			return forumStateTypes;
		}
		/**
		* 设置： 帖子状态
		*/
		public void setForumStateTypes(Integer forumStateTypes) {
			this.forumStateTypes = forumStateTypes;
		}


			/**
			* 获取： 帖子状态的值
			*/
			public String getForumStateValue() {
				return forumStateValue;
			}
			/**
			* 设置： 帖子状态的值
			*/
			public void setForumStateValue(String forumStateValue) {
				this.forumStateValue = forumStateValue;
			}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "ForumCollectionView{" +
			", forumCollectionValue=" + forumCollectionValue +
			", forumName=" + forumName +
//			", usersId=" + usersId +
			", forumContent=" + forumContent +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", superIds=" + superIds +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
