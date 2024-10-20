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
 * 成果验收
 *
 * @author 
 * @email
 */
@TableName("yanshou_chengguo")
public class YanshouChengguoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YanshouChengguoEntity() {

	}

	public YanshouChengguoEntity(T t) {
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
     * 验收部位
     */
    @ColumnInfo(comment="验收部位",type="varchar(200)")
    @TableField(value = "yanshou_chengguo_buwei")

    private String yanshouChengguoBuwei;


    /**
     * 船东要求
     */
    @ColumnInfo(comment="船东要求",type="varchar(200)")
    @TableField(value = "yanshou_chengguo_chuandong")

    private String yanshouChengguoChuandong;


    /**
     * 实际结果
     */
    @ColumnInfo(comment="实际结果",type="varchar(200)")
    @TableField(value = "yanshou_chengguo_shiji")

    private String yanshouChengguoShiji;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "jianzaojindu_file")

    private String jianzaojinduFile;


    /**
     * 是否合格
     */
    @ColumnInfo(comment="是否合格",type="int(11)")
    @TableField(value = "hege_types")

    private Integer hegeTypes;


    /**
     * 验收时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="验收时间",type="timestamp")
    @TableField(value = "yanshou_time")

    private Date yanshouTime;


    /**
     * 缘由
     */
    @ColumnInfo(comment="缘由",type="longtext")
    @TableField(value = "yanshou_chengguo_content")

    private String yanshouChengguoContent;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "yanshou_chengguo_beizhu_content")

    private String yanshouChengguoBeizhuContent;


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
	 * 获取：验收部位
	 */
    public String getYanshouChengguoBuwei() {
        return yanshouChengguoBuwei;
    }
    /**
	 * 设置：验收部位
	 */

    public void setYanshouChengguoBuwei(String yanshouChengguoBuwei) {
        this.yanshouChengguoBuwei = yanshouChengguoBuwei;
    }
    /**
	 * 获取：船东要求
	 */
    public String getYanshouChengguoChuandong() {
        return yanshouChengguoChuandong;
    }
    /**
	 * 设置：船东要求
	 */

    public void setYanshouChengguoChuandong(String yanshouChengguoChuandong) {
        this.yanshouChengguoChuandong = yanshouChengguoChuandong;
    }
    /**
	 * 获取：实际结果
	 */
    public String getYanshouChengguoShiji() {
        return yanshouChengguoShiji;
    }
    /**
	 * 设置：实际结果
	 */

    public void setYanshouChengguoShiji(String yanshouChengguoShiji) {
        this.yanshouChengguoShiji = yanshouChengguoShiji;
    }
    /**
	 * 获取：附件
	 */
    public String getJianzaojinduFile() {
        return jianzaojinduFile;
    }
    /**
	 * 设置：附件
	 */

    public void setJianzaojinduFile(String jianzaojinduFile) {
        this.jianzaojinduFile = jianzaojinduFile;
    }
    /**
	 * 获取：是否合格
	 */
    public Integer getHegeTypes() {
        return hegeTypes;
    }
    /**
	 * 设置：是否合格
	 */

    public void setHegeTypes(Integer hegeTypes) {
        this.hegeTypes = hegeTypes;
    }
    /**
	 * 获取：验收时间
	 */
    public Date getYanshouTime() {
        return yanshouTime;
    }
    /**
	 * 设置：验收时间
	 */

    public void setYanshouTime(Date yanshouTime) {
        this.yanshouTime = yanshouTime;
    }
    /**
	 * 获取：缘由
	 */
    public String getYanshouChengguoContent() {
        return yanshouChengguoContent;
    }
    /**
	 * 设置：缘由
	 */

    public void setYanshouChengguoContent(String yanshouChengguoContent) {
        this.yanshouChengguoContent = yanshouChengguoContent;
    }
    /**
	 * 获取：备注
	 */
    public String getYanshouChengguoBeizhuContent() {
        return yanshouChengguoBeizhuContent;
    }
    /**
	 * 设置：备注
	 */

    public void setYanshouChengguoBeizhuContent(String yanshouChengguoBeizhuContent) {
        this.yanshouChengguoBeizhuContent = yanshouChengguoBeizhuContent;
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
        return "YanshouChengguo{" +
            ", id=" + id +
            ", xiangmuId=" + xiangmuId +
            ", yuangongId=" + yuangongId +
            ", yanshouChengguoBuwei=" + yanshouChengguoBuwei +
            ", yanshouChengguoChuandong=" + yanshouChengguoChuandong +
            ", yanshouChengguoShiji=" + yanshouChengguoShiji +
            ", jianzaojinduFile=" + jianzaojinduFile +
            ", hegeTypes=" + hegeTypes +
            ", yanshouTime=" + DateUtil.convertString(yanshouTime,"yyyy-MM-dd") +
            ", yanshouChengguoContent=" + yanshouChengguoContent +
            ", yanshouChengguoBeizhuContent=" + yanshouChengguoBeizhuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
