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
 * 项目图纸
 *
 * @author 
 * @email
 */
@TableName("xiangmu_tuzhi")
public class XiangmuTuzhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuTuzhiEntity() {

	}

	public XiangmuTuzhiEntity(T t) {
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
     * 项目
     */
    @ColumnInfo(comment="项目",type="int(11)")
    @TableField(value = "xiangmu_id")

    private Integer xiangmuId;


    /**
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 图纸编号
     */
    @ColumnInfo(comment="图纸编号",type="varchar(200)")
    @TableField(value = "xiangmu_tuzhi_uuid_number")

    private String xiangmuTuzhiUuidNumber;


    /**
     * 图纸名称
     */
    @ColumnInfo(comment="图纸名称",type="varchar(200)")
    @TableField(value = "xiangmu_tuzhi_name")

    private String xiangmuTuzhiName;


    /**
     * 图纸文件
     */
    @ColumnInfo(comment="图纸文件",type="varchar(200)")
    @TableField(value = "xiangmu_tuzhi_file")

    private String xiangmuTuzhiFile;


    /**
     * 图纸类型
     */
    @ColumnInfo(comment="图纸类型",type="int(11)")
    @TableField(value = "xiangmu_tuzhi_types")

    private Integer xiangmuTuzhiTypes;


    /**
     * 图纸介绍
     */
    @ColumnInfo(comment="图纸介绍",type="longtext")
    @TableField(value = "xiangmu_tuzhi_content")

    private String xiangmuTuzhiContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "xiangmu_tuzhi_yesno_types")

    private Integer xiangmuTuzhiYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "xiangmu_tuzhi_yesno_text")

    private String xiangmuTuzhiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "xiangmu_tuzhi_shenhe_time")

    private Date xiangmuTuzhiShenheTime;


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
	 * 获取：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }
    /**
	 * 设置：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 设置：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：图纸编号
	 */
    public String getXiangmuTuzhiUuidNumber() {
        return xiangmuTuzhiUuidNumber;
    }
    /**
	 * 设置：图纸编号
	 */

    public void setXiangmuTuzhiUuidNumber(String xiangmuTuzhiUuidNumber) {
        this.xiangmuTuzhiUuidNumber = xiangmuTuzhiUuidNumber;
    }
    /**
	 * 获取：图纸名称
	 */
    public String getXiangmuTuzhiName() {
        return xiangmuTuzhiName;
    }
    /**
	 * 设置：图纸名称
	 */

    public void setXiangmuTuzhiName(String xiangmuTuzhiName) {
        this.xiangmuTuzhiName = xiangmuTuzhiName;
    }
    /**
	 * 获取：图纸文件
	 */
    public String getXiangmuTuzhiFile() {
        return xiangmuTuzhiFile;
    }
    /**
	 * 设置：图纸文件
	 */

    public void setXiangmuTuzhiFile(String xiangmuTuzhiFile) {
        this.xiangmuTuzhiFile = xiangmuTuzhiFile;
    }
    /**
	 * 获取：图纸类型
	 */
    public Integer getXiangmuTuzhiTypes() {
        return xiangmuTuzhiTypes;
    }
    /**
	 * 设置：图纸类型
	 */

    public void setXiangmuTuzhiTypes(Integer xiangmuTuzhiTypes) {
        this.xiangmuTuzhiTypes = xiangmuTuzhiTypes;
    }
    /**
	 * 获取：图纸介绍
	 */
    public String getXiangmuTuzhiContent() {
        return xiangmuTuzhiContent;
    }
    /**
	 * 设置：图纸介绍
	 */

    public void setXiangmuTuzhiContent(String xiangmuTuzhiContent) {
        this.xiangmuTuzhiContent = xiangmuTuzhiContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getXiangmuTuzhiYesnoTypes() {
        return xiangmuTuzhiYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setXiangmuTuzhiYesnoTypes(Integer xiangmuTuzhiYesnoTypes) {
        this.xiangmuTuzhiYesnoTypes = xiangmuTuzhiYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getXiangmuTuzhiYesnoText() {
        return xiangmuTuzhiYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setXiangmuTuzhiYesnoText(String xiangmuTuzhiYesnoText) {
        this.xiangmuTuzhiYesnoText = xiangmuTuzhiYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getXiangmuTuzhiShenheTime() {
        return xiangmuTuzhiShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setXiangmuTuzhiShenheTime(Date xiangmuTuzhiShenheTime) {
        this.xiangmuTuzhiShenheTime = xiangmuTuzhiShenheTime;
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
        return "XiangmuTuzhi{" +
            ", id=" + id +
            ", xiangmuId=" + xiangmuId +
            ", yuangongId=" + yuangongId +
            ", xiangmuTuzhiUuidNumber=" + xiangmuTuzhiUuidNumber +
            ", xiangmuTuzhiName=" + xiangmuTuzhiName +
            ", xiangmuTuzhiFile=" + xiangmuTuzhiFile +
            ", xiangmuTuzhiTypes=" + xiangmuTuzhiTypes +
            ", xiangmuTuzhiContent=" + xiangmuTuzhiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", xiangmuTuzhiYesnoTypes=" + xiangmuTuzhiYesnoTypes +
            ", xiangmuTuzhiYesnoText=" + xiangmuTuzhiYesnoText +
            ", xiangmuTuzhiShenheTime=" + DateUtil.convertString(xiangmuTuzhiShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
