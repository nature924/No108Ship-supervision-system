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
 * 经费预估
 *
 * @author 
 * @email
 */
@TableName("jingfeiyugu")
public class JingfeiyuguEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingfeiyuguEntity() {

	}

	public JingfeiyuguEntity(T t) {
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
     * 经费预估编号
     */
    @ColumnInfo(comment="经费预估编号",type="varchar(200)")
    @TableField(value = "jingfeiyugu_uuid_number")

    private String jingfeiyuguUuidNumber;


    /**
     * 材料名称
     */
    @ColumnInfo(comment="材料名称",type="varchar(200)")
    @TableField(value = "jingfeiyugu_name")

    private String jingfeiyuguName;


    /**
     * 单价单位
     */
    @ColumnInfo(comment="单价单位",type="varchar(200)")
    @TableField(value = "jingfeiyugu_danwei")

    private String jingfeiyuguDanwei;


    /**
     * 材料单价
     */
    @ColumnInfo(comment="材料单价",type="decimal(10,2)")
    @TableField(value = "jingfeiyugu_danjia")

    private Double jingfeiyuguDanjia;


    /**
     * 材料类型
     */
    @ColumnInfo(comment="材料类型",type="int(11)")
    @TableField(value = "cailiao_types")

    private Integer cailiaoTypes;


    /**
     * 所需数量
     */
    @ColumnInfo(comment="所需数量",type="int(11)")
    @TableField(value = "jingfeiyugu_number")

    private Integer jingfeiyuguNumber;


    /**
     * 预计总价
     */
    @ColumnInfo(comment="预计总价",type="decimal(10,2)")
    @TableField(value = "jingfeiyugu_zongjia")

    private Double jingfeiyuguZongjia;


    /**
     * 推荐公司
     */
    @ColumnInfo(comment="推荐公司",type="varchar(200)")
    @TableField(value = "jingfeiyugu_gongsi")

    private String jingfeiyuguGongsi;


    /**
     * 执行标准
     */
    @ColumnInfo(comment="执行标准",type="varchar(200)")
    @TableField(value = "jingfeiyugu_file")

    private String jingfeiyuguFile;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "jingfeiyugu_content")

    private String jingfeiyuguContent;


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
	 * 获取：经费预估编号
	 */
    public String getJingfeiyuguUuidNumber() {
        return jingfeiyuguUuidNumber;
    }
    /**
	 * 设置：经费预估编号
	 */

    public void setJingfeiyuguUuidNumber(String jingfeiyuguUuidNumber) {
        this.jingfeiyuguUuidNumber = jingfeiyuguUuidNumber;
    }
    /**
	 * 获取：材料名称
	 */
    public String getJingfeiyuguName() {
        return jingfeiyuguName;
    }
    /**
	 * 设置：材料名称
	 */

    public void setJingfeiyuguName(String jingfeiyuguName) {
        this.jingfeiyuguName = jingfeiyuguName;
    }
    /**
	 * 获取：单价单位
	 */
    public String getJingfeiyuguDanwei() {
        return jingfeiyuguDanwei;
    }
    /**
	 * 设置：单价单位
	 */

    public void setJingfeiyuguDanwei(String jingfeiyuguDanwei) {
        this.jingfeiyuguDanwei = jingfeiyuguDanwei;
    }
    /**
	 * 获取：材料单价
	 */
    public Double getJingfeiyuguDanjia() {
        return jingfeiyuguDanjia;
    }
    /**
	 * 设置：材料单价
	 */

    public void setJingfeiyuguDanjia(Double jingfeiyuguDanjia) {
        this.jingfeiyuguDanjia = jingfeiyuguDanjia;
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
	 * 获取：所需数量
	 */
    public Integer getJingfeiyuguNumber() {
        return jingfeiyuguNumber;
    }
    /**
	 * 设置：所需数量
	 */

    public void setJingfeiyuguNumber(Integer jingfeiyuguNumber) {
        this.jingfeiyuguNumber = jingfeiyuguNumber;
    }
    /**
	 * 获取：预计总价
	 */
    public Double getJingfeiyuguZongjia() {
        return jingfeiyuguZongjia;
    }
    /**
	 * 设置：预计总价
	 */

    public void setJingfeiyuguZongjia(Double jingfeiyuguZongjia) {
        this.jingfeiyuguZongjia = jingfeiyuguZongjia;
    }
    /**
	 * 获取：推荐公司
	 */
    public String getJingfeiyuguGongsi() {
        return jingfeiyuguGongsi;
    }
    /**
	 * 设置：推荐公司
	 */

    public void setJingfeiyuguGongsi(String jingfeiyuguGongsi) {
        this.jingfeiyuguGongsi = jingfeiyuguGongsi;
    }
    /**
	 * 获取：执行标准
	 */
    public String getJingfeiyuguFile() {
        return jingfeiyuguFile;
    }
    /**
	 * 设置：执行标准
	 */

    public void setJingfeiyuguFile(String jingfeiyuguFile) {
        this.jingfeiyuguFile = jingfeiyuguFile;
    }
    /**
	 * 获取：备注
	 */
    public String getJingfeiyuguContent() {
        return jingfeiyuguContent;
    }
    /**
	 * 设置：备注
	 */

    public void setJingfeiyuguContent(String jingfeiyuguContent) {
        this.jingfeiyuguContent = jingfeiyuguContent;
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
        return "Jingfeiyugu{" +
            ", id=" + id +
            ", xiangmuId=" + xiangmuId +
            ", yuangongId=" + yuangongId +
            ", jingfeiyuguUuidNumber=" + jingfeiyuguUuidNumber +
            ", jingfeiyuguName=" + jingfeiyuguName +
            ", jingfeiyuguDanwei=" + jingfeiyuguDanwei +
            ", jingfeiyuguDanjia=" + jingfeiyuguDanjia +
            ", cailiaoTypes=" + cailiaoTypes +
            ", jingfeiyuguNumber=" + jingfeiyuguNumber +
            ", jingfeiyuguZongjia=" + jingfeiyuguZongjia +
            ", jingfeiyuguGongsi=" + jingfeiyuguGongsi +
            ", jingfeiyuguFile=" + jingfeiyuguFile +
            ", jingfeiyuguContent=" + jingfeiyuguContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
