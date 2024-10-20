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
 * 材料参考
 *
 * @author 
 * @email
 */
@TableName("cailiaocankao")
public class CailiaocankaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CailiaocankaoEntity() {

	}

	public CailiaocankaoEntity(T t) {
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
     * 材料编号
     */
    @ColumnInfo(comment="材料编号",type="varchar(200)")
    @TableField(value = "cailiaocankao_uuid_number")

    private String cailiaocankaoUuidNumber;


    /**
     * 材料名称
     */
    @ColumnInfo(comment="材料名称",type="varchar(200)")
    @TableField(value = "cailiaocankao_name")

    private String cailiaocankaoName;


    /**
     * 材料类型
     */
    @ColumnInfo(comment="材料类型",type="int(11)")
    @TableField(value = "cailiao_types")

    private Integer cailiaoTypes;


    /**
     * 单价单位
     */
    @ColumnInfo(comment="单价单位",type="varchar(200)")
    @TableField(value = "cailiaocankao_danwei")

    private String cailiaocankaoDanwei;


    /**
     * 参考单价
     */
    @ColumnInfo(comment="参考单价",type="decimal(10,2)")
    @TableField(value = "cailiaocankao_danjia")

    private Double cailiaocankaoDanjia;


    /**
     * 材料规格
     */
    @ColumnInfo(comment="材料规格",type="varchar(200)")
    @TableField(value = "cailiaocankao_guige")

    private String cailiaocankaoGuige;


    /**
     * 执行标准
     */
    @ColumnInfo(comment="执行标准",type="varchar(200)")
    @TableField(value = "cailiaocankao_file")

    private String cailiaocankaoFile;


    /**
     * 推荐公司
     */
    @ColumnInfo(comment="推荐公司",type="varchar(200)")
    @TableField(value = "cailiaocankao_gongsi")

    private String cailiaocankaoGongsi;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "cailiaocankao_content")

    private String cailiaocankaoContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
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
	 * 获取：材料编号
	 */
    public String getCailiaocankaoUuidNumber() {
        return cailiaocankaoUuidNumber;
    }
    /**
	 * 设置：材料编号
	 */

    public void setCailiaocankaoUuidNumber(String cailiaocankaoUuidNumber) {
        this.cailiaocankaoUuidNumber = cailiaocankaoUuidNumber;
    }
    /**
	 * 获取：材料名称
	 */
    public String getCailiaocankaoName() {
        return cailiaocankaoName;
    }
    /**
	 * 设置：材料名称
	 */

    public void setCailiaocankaoName(String cailiaocankaoName) {
        this.cailiaocankaoName = cailiaocankaoName;
    }
    /**
	 * 获取：材料类型
	 */
    public Integer getCailiaoTypes() {
        return cailiaoTypes;
    }
    /**
	 * 设置：材料类型
	 */

    public void setCailiaoTypes(Integer cailiaoTypes) {
        this.cailiaoTypes = cailiaoTypes;
    }
    /**
	 * 获取：单价单位
	 */
    public String getCailiaocankaoDanwei() {
        return cailiaocankaoDanwei;
    }
    /**
	 * 设置：单价单位
	 */

    public void setCailiaocankaoDanwei(String cailiaocankaoDanwei) {
        this.cailiaocankaoDanwei = cailiaocankaoDanwei;
    }
    /**
	 * 获取：参考单价
	 */
    public Double getCailiaocankaoDanjia() {
        return cailiaocankaoDanjia;
    }
    /**
	 * 设置：参考单价
	 */

    public void setCailiaocankaoDanjia(Double cailiaocankaoDanjia) {
        this.cailiaocankaoDanjia = cailiaocankaoDanjia;
    }
    /**
	 * 获取：材料规格
	 */
    public String getCailiaocankaoGuige() {
        return cailiaocankaoGuige;
    }
    /**
	 * 设置：材料规格
	 */

    public void setCailiaocankaoGuige(String cailiaocankaoGuige) {
        this.cailiaocankaoGuige = cailiaocankaoGuige;
    }
    /**
	 * 获取：执行标准
	 */
    public String getCailiaocankaoFile() {
        return cailiaocankaoFile;
    }
    /**
	 * 设置：执行标准
	 */

    public void setCailiaocankaoFile(String cailiaocankaoFile) {
        this.cailiaocankaoFile = cailiaocankaoFile;
    }
    /**
	 * 获取：推荐公司
	 */
    public String getCailiaocankaoGongsi() {
        return cailiaocankaoGongsi;
    }
    /**
	 * 设置：推荐公司
	 */

    public void setCailiaocankaoGongsi(String cailiaocankaoGongsi) {
        this.cailiaocankaoGongsi = cailiaocankaoGongsi;
    }
    /**
	 * 获取：备注
	 */
    public String getCailiaocankaoContent() {
        return cailiaocankaoContent;
    }
    /**
	 * 设置：备注
	 */

    public void setCailiaocankaoContent(String cailiaocankaoContent) {
        this.cailiaocankaoContent = cailiaocankaoContent;
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
        return "Cailiaocankao{" +
            ", id=" + id +
            ", cailiaocankaoUuidNumber=" + cailiaocankaoUuidNumber +
            ", cailiaocankaoName=" + cailiaocankaoName +
            ", cailiaoTypes=" + cailiaoTypes +
            ", cailiaocankaoDanwei=" + cailiaocankaoDanwei +
            ", cailiaocankaoDanjia=" + cailiaocankaoDanjia +
            ", cailiaocankaoGuige=" + cailiaocankaoGuige +
            ", cailiaocankaoFile=" + cailiaocankaoFile +
            ", cailiaocankaoGongsi=" + cailiaocankaoGongsi +
            ", cailiaocankaoContent=" + cailiaocankaoContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
