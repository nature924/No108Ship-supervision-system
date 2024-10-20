package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JianzaocaiwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 监造财务
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jianzaocaiwu")
public class JianzaocaiwuView extends JianzaocaiwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 消费类型的值
	*/
	@ColumnInfo(comment="消费类型的字典表值",type="varchar(200)")
	private String jianzaocaiwuValue;
	/**
	* 是否合格的值
	*/
	@ColumnInfo(comment="是否合格的字典表值",type="varchar(200)")
	private String hegeValue;

	//级联表 项目
					 
		/**
		* 项目 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer xiangmuYonghuId;
		/**
		* 项目编号
		*/

		@ColumnInfo(comment="项目编号",type="varchar(200)")
		private String xiangmuUuidNumber;
		/**
		* 项目名称
		*/

		@ColumnInfo(comment="项目名称",type="varchar(200)")
		private String xiangmuName;
		/**
		* 监造地点
		*/

		@ColumnInfo(comment="监造地点",type="varchar(200)")
		private String xiangmuAddress;
		/**
		* 建造资料
		*/

		@ColumnInfo(comment="建造资料",type="varchar(200)")
		private String xiangmuFile;
		/**
		* 项目类型
		*/
		@ColumnInfo(comment="项目类型",type="int(11)")
		private Integer xiangmuTypes;
			/**
			* 项目类型的值
			*/
			@ColumnInfo(comment="项目类型的字典表值",type="varchar(200)")
			private String xiangmuValue;
		/**
		* 监造数量
		*/

		@ColumnInfo(comment="监造数量",type="int(11)")
		private Integer xiangmuKucunNumber;
		/**
		* 申请时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="申请时间",type="timestamp")
		private Date shenqingTime;
		/**
		* 拿船时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="拿船时间",type="timestamp")
		private Date nachuanTime;
		/**
		* 监造要求
		*/

		@ColumnInfo(comment="监造要求",type="longtext")
		private String xiangmuContent;
	//级联表 员工
		/**
		* 员工编号
		*/

		@ColumnInfo(comment="员工编号",type="varchar(200)")
		private String yuangongUuidNumber;
		/**
		* 员工姓名
		*/

		@ColumnInfo(comment="员工姓名",type="varchar(200)")
		private String yuangongName;
		/**
		* 员工手机号
		*/

		@ColumnInfo(comment="员工手机号",type="varchar(200)")
		private String yuangongPhone;
		/**
		* 员工身份证号
		*/

		@ColumnInfo(comment="员工身份证号",type="varchar(200)")
		private String yuangongIdNumber;
		/**
		* 员工头像
		*/

		@ColumnInfo(comment="员工头像",type="varchar(200)")
		private String yuangongPhoto;
		/**
		* 部门
		*/
		@ColumnInfo(comment="部门",type="int(11)")
		private Integer bumenTypes;
			/**
			* 部门的值
			*/
			@ColumnInfo(comment="部门的字典表值",type="varchar(200)")
			private String bumenValue;
		/**
		* 职位
		*/
		@ColumnInfo(comment="职位",type="int(11)")
		private Integer zhiweiTypes;
			/**
			* 职位的值
			*/
			@ColumnInfo(comment="职位的字典表值",type="varchar(200)")
			private String zhiweiValue;
		/**
		* 员工邮箱
		*/

		@ColumnInfo(comment="员工邮箱",type="varchar(200)")
		private String yuangongEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public JianzaocaiwuView() {

	}

	public JianzaocaiwuView(JianzaocaiwuEntity jianzaocaiwuEntity) {
		try {
			BeanUtils.copyProperties(this, jianzaocaiwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 消费类型的值
	*/
	public String getJianzaocaiwuValue() {
		return jianzaocaiwuValue;
	}
	/**
	* 设置： 消费类型的值
	*/
	public void setJianzaocaiwuValue(String jianzaocaiwuValue) {
		this.jianzaocaiwuValue = jianzaocaiwuValue;
	}
	//当前表的
	/**
	* 获取： 是否合格的值
	*/
	public String getHegeValue() {
		return hegeValue;
	}
	/**
	* 设置： 是否合格的值
	*/
	public void setHegeValue(String hegeValue) {
		this.hegeValue = hegeValue;
	}


	//级联表的get和set 项目
		/**
		* 获取：项目 的 用户
		*/
		public Integer getXiangmuYonghuId() {
			return xiangmuYonghuId;
		}
		/**
		* 设置：项目 的 用户
		*/
		public void setXiangmuYonghuId(Integer xiangmuYonghuId) {
			this.xiangmuYonghuId = xiangmuYonghuId;
		}

		/**
		* 获取： 项目编号
		*/
		public String getXiangmuUuidNumber() {
			return xiangmuUuidNumber;
		}
		/**
		* 设置： 项目编号
		*/
		public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
			this.xiangmuUuidNumber = xiangmuUuidNumber;
		}

		/**
		* 获取： 项目名称
		*/
		public String getXiangmuName() {
			return xiangmuName;
		}
		/**
		* 设置： 项目名称
		*/
		public void setXiangmuName(String xiangmuName) {
			this.xiangmuName = xiangmuName;
		}

		/**
		* 获取： 监造地点
		*/
		public String getXiangmuAddress() {
			return xiangmuAddress;
		}
		/**
		* 设置： 监造地点
		*/
		public void setXiangmuAddress(String xiangmuAddress) {
			this.xiangmuAddress = xiangmuAddress;
		}

		/**
		* 获取： 建造资料
		*/
		public String getXiangmuFile() {
			return xiangmuFile;
		}
		/**
		* 设置： 建造资料
		*/
		public void setXiangmuFile(String xiangmuFile) {
			this.xiangmuFile = xiangmuFile;
		}
		/**
		* 获取： 项目类型
		*/
		public Integer getXiangmuTypes() {
			return xiangmuTypes;
		}
		/**
		* 设置： 项目类型
		*/
		public void setXiangmuTypes(Integer xiangmuTypes) {
			this.xiangmuTypes = xiangmuTypes;
		}


			/**
			* 获取： 项目类型的值
			*/
			public String getXiangmuValue() {
				return xiangmuValue;
			}
			/**
			* 设置： 项目类型的值
			*/
			public void setXiangmuValue(String xiangmuValue) {
				this.xiangmuValue = xiangmuValue;
			}

		/**
		* 获取： 监造数量
		*/
		public Integer getXiangmuKucunNumber() {
			return xiangmuKucunNumber;
		}
		/**
		* 设置： 监造数量
		*/
		public void setXiangmuKucunNumber(Integer xiangmuKucunNumber) {
			this.xiangmuKucunNumber = xiangmuKucunNumber;
		}

		/**
		* 获取： 申请时间
		*/
		public Date getShenqingTime() {
			return shenqingTime;
		}
		/**
		* 设置： 申请时间
		*/
		public void setShenqingTime(Date shenqingTime) {
			this.shenqingTime = shenqingTime;
		}

		/**
		* 获取： 拿船时间
		*/
		public Date getNachuanTime() {
			return nachuanTime;
		}
		/**
		* 设置： 拿船时间
		*/
		public void setNachuanTime(Date nachuanTime) {
			this.nachuanTime = nachuanTime;
		}

		/**
		* 获取： 监造要求
		*/
		public String getXiangmuContent() {
			return xiangmuContent;
		}
		/**
		* 设置： 监造要求
		*/
		public void setXiangmuContent(String xiangmuContent) {
			this.xiangmuContent = xiangmuContent;
		}
	//级联表的get和set 员工

		/**
		* 获取： 员工编号
		*/
		public String getYuangongUuidNumber() {
			return yuangongUuidNumber;
		}
		/**
		* 设置： 员工编号
		*/
		public void setYuangongUuidNumber(String yuangongUuidNumber) {
			this.yuangongUuidNumber = yuangongUuidNumber;
		}

		/**
		* 获取： 员工姓名
		*/
		public String getYuangongName() {
			return yuangongName;
		}
		/**
		* 设置： 员工姓名
		*/
		public void setYuangongName(String yuangongName) {
			this.yuangongName = yuangongName;
		}

		/**
		* 获取： 员工手机号
		*/
		public String getYuangongPhone() {
			return yuangongPhone;
		}
		/**
		* 设置： 员工手机号
		*/
		public void setYuangongPhone(String yuangongPhone) {
			this.yuangongPhone = yuangongPhone;
		}

		/**
		* 获取： 员工身份证号
		*/
		public String getYuangongIdNumber() {
			return yuangongIdNumber;
		}
		/**
		* 设置： 员工身份证号
		*/
		public void setYuangongIdNumber(String yuangongIdNumber) {
			this.yuangongIdNumber = yuangongIdNumber;
		}

		/**
		* 获取： 员工头像
		*/
		public String getYuangongPhoto() {
			return yuangongPhoto;
		}
		/**
		* 设置： 员工头像
		*/
		public void setYuangongPhoto(String yuangongPhoto) {
			this.yuangongPhoto = yuangongPhoto;
		}
		/**
		* 获取： 部门
		*/
		public Integer getBumenTypes() {
			return bumenTypes;
		}
		/**
		* 设置： 部门
		*/
		public void setBumenTypes(Integer bumenTypes) {
			this.bumenTypes = bumenTypes;
		}


			/**
			* 获取： 部门的值
			*/
			public String getBumenValue() {
				return bumenValue;
			}
			/**
			* 设置： 部门的值
			*/
			public void setBumenValue(String bumenValue) {
				this.bumenValue = bumenValue;
			}
		/**
		* 获取： 职位
		*/
		public Integer getZhiweiTypes() {
			return zhiweiTypes;
		}
		/**
		* 设置： 职位
		*/
		public void setZhiweiTypes(Integer zhiweiTypes) {
			this.zhiweiTypes = zhiweiTypes;
		}


			/**
			* 获取： 职位的值
			*/
			public String getZhiweiValue() {
				return zhiweiValue;
			}
			/**
			* 设置： 职位的值
			*/
			public void setZhiweiValue(String zhiweiValue) {
				this.zhiweiValue = zhiweiValue;
			}

		/**
		* 获取： 员工邮箱
		*/
		public String getYuangongEmail() {
			return yuangongEmail;
		}
		/**
		* 设置： 员工邮箱
		*/
		public void setYuangongEmail(String yuangongEmail) {
			this.yuangongEmail = yuangongEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "JianzaocaiwuView{" +
			", jianzaocaiwuValue=" + jianzaocaiwuValue +
			", hegeValue=" + hegeValue +
			", xiangmuUuidNumber=" + xiangmuUuidNumber +
			", xiangmuName=" + xiangmuName +
			", xiangmuAddress=" + xiangmuAddress +
			", xiangmuFile=" + xiangmuFile +
			", xiangmuKucunNumber=" + xiangmuKucunNumber +
			", shenqingTime=" + DateUtil.convertString(shenqingTime,"yyyy-MM-dd") +
			", nachuanTime=" + DateUtil.convertString(nachuanTime,"yyyy-MM-dd") +
			", xiangmuContent=" + xiangmuContent +
			", yuangongUuidNumber=" + yuangongUuidNumber +
			", yuangongName=" + yuangongName +
			", yuangongPhone=" + yuangongPhone +
			", yuangongIdNumber=" + yuangongIdNumber +
			", yuangongPhoto=" + yuangongPhoto +
			", yuangongEmail=" + yuangongEmail +
			"} " + super.toString();
	}
}
