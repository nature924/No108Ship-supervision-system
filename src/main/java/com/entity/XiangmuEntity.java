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
 * 项目
 *
 * @author 
 * @email
 */
@TableName("xiangmu")
public class XiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuEntity() {

	}

	public XiangmuEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 项目编号
     */
    @ColumnInfo(comment="项目编号",type="varchar(200)")
    @TableField(value = "xiangmu_uuid_number")

    private String xiangmuUuidNumber;


    /**
     * 项目名称
     */
    @ColumnInfo(comment="项目名称",type="varchar(200)")
    @TableField(value = "xiangmu_name")

    private String xiangmuName;


    /**
     * 监造地点
     */
    @ColumnInfo(comment="监造地点",type="varchar(200)")
    @TableField(value = "xiangmu_address")

    private String xiangmuAddress;


    /**
     * 建造资料
     */
    @ColumnInfo(comment="建造资料",type="varchar(200)")
    @TableField(value = "xiangmu_file")

    private String xiangmuFile;


    /**
     * 项目类型
     */
    @ColumnInfo(comment="项目类型",type="int(11)")
    @TableField(value = "xiangmu_types")

    private Integer xiangmuTypes;


    /**
     * 监造数量
     */
    @ColumnInfo(comment="监造数量",type="int(11)")
    @TableField(value = "xiangmu_kucun_number")

    private Integer xiangmuKucunNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "shenqing_time")

    private Date shenqingTime;


    /**
     * 拿船时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="拿船时间",type="timestamp")
    @TableField(value = "nachuan_time")

    private Date nachuanTime;


    /**
     * 监造要求
     */
    @ColumnInfo(comment="监造要求",type="longtext")
    @TableField(value = "xiangmu_content")

    private String xiangmuContent;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：项目编号
	 */
    public String getXiangmuUuidNumber() {
        return xiangmuUuidNumber;
    }
    /**
	 * 设置：项目编号
	 */

    public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
        this.xiangmuUuidNumber = xiangmuUuidNumber;
    }
    /**
	 * 获取：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }
    /**
	 * 设置：项目名称
	 */

    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 获取：监造地点
	 */
    public String getXiangmuAddress() {
        return xiangmuAddress;
    }
    /**
	 * 设置：监造地点
	 */

    public void setXiangmuAddress(String xiangmuAddress) {
        this.xiangmuAddress = xiangmuAddress;
    }
    /**
	 * 获取：建造资料
	 */
    public String getXiangmuFile() {
        return xiangmuFile;
    }
    /**
	 * 设置：建造资料
	 */

    public void setXiangmuFile(String xiangmuFile) {
        this.xiangmuFile = xiangmuFile;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }
    /**
	 * 设置：项目类型
	 */

    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 获取：监造数量
	 */
    public Integer getXiangmuKucunNumber() {
        return xiangmuKucunNumber;
    }
    /**
	 * 设置：监造数量
	 */

    public void setXiangmuKucunNumber(Integer xiangmuKucunNumber) {
        this.xiangmuKucunNumber = xiangmuKucunNumber;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getShenqingTime() {
        return shenqingTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setShenqingTime(Date shenqingTime) {
        this.shenqingTime = shenqingTime;
    }
    /**
	 * 获取：拿船时间
	 */
    public Date getNachuanTime() {
        return nachuanTime;
    }
    /**
	 * 设置：拿船时间
	 */

    public void setNachuanTime(Date nachuanTime) {
        this.nachuanTime = nachuanTime;
    }
    /**
	 * 获取：监造要求
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }
    /**
	 * 设置：监造要求
	 */

    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
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
        return "Xiangmu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", xiangmuUuidNumber=" + xiangmuUuidNumber +
            ", xiangmuName=" + xiangmuName +
            ", xiangmuAddress=" + xiangmuAddress +
            ", xiangmuFile=" + xiangmuFile +
            ", xiangmuTypes=" + xiangmuTypes +
            ", xiangmuKucunNumber=" + xiangmuKucunNumber +
            ", shenqingTime=" + DateUtil.convertString(shenqingTime,"yyyy-MM-dd") +
            ", nachuanTime=" + DateUtil.convertString(nachuanTime,"yyyy-MM-dd") +
            ", xiangmuContent=" + xiangmuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
