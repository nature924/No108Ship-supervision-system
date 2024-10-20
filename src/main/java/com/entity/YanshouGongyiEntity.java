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
 * 工艺验收
 *
 * @author 
 * @email
 */
@TableName("yanshou_gongyi")
public class YanshouGongyiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YanshouGongyiEntity() {

	}

	public YanshouGongyiEntity(T t) {
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
     * 工艺名称
     */
    @ColumnInfo(comment="工艺名称",type="varchar(200)")
    @TableField(value = "yanshou_gongyi_name")

    private String yanshouGongyiName;


    /**
     * 验收部位
     */
    @ColumnInfo(comment="验收部位",type="varchar(200)")
    @TableField(value = "yanshou_gongyi_buwei")

    private String yanshouGongyiBuwei;


    /**
     * 使用标准
     */
    @ColumnInfo(comment="使用标准",type="varchar(200)")
    @TableField(value = "yanshou_gongyi_biaozhun")

    private String yanshouGongyiBiaozhun;


    /**
     * 实际使用
     */
    @ColumnInfo(comment="实际使用",type="varchar(200)")
    @TableField(value = "yanshou_gongyi_shijishiyong")

    private String yanshouGongyiShijishiyong;


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
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "yanshou_gongyi_content")

    private String yanshouGongyiContent;


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
	 * 获取：工艺名称
	 */
    public String getYanshouGongyiName() {
        return yanshouGongyiName;
    }
    /**
	 * 设置：工艺名称
	 */

    public void setYanshouGongyiName(String yanshouGongyiName) {
        this.yanshouGongyiName = yanshouGongyiName;
    }
    /**
	 * 获取：验收部位
	 */
    public String getYanshouGongyiBuwei() {
        return yanshouGongyiBuwei;
    }
    /**
	 * 设置：验收部位
	 */

    public void setYanshouGongyiBuwei(String yanshouGongyiBuwei) {
        this.yanshouGongyiBuwei = yanshouGongyiBuwei;
    }
    /**
	 * 获取：使用标准
	 */
    public String getYanshouGongyiBiaozhun() {
        return yanshouGongyiBiaozhun;
    }
    /**
	 * 设置：使用标准
	 */

    public void setYanshouGongyiBiaozhun(String yanshouGongyiBiaozhun) {
        this.yanshouGongyiBiaozhun = yanshouGongyiBiaozhun;
    }
    /**
	 * 获取：实际使用
	 */
    public String getYanshouGongyiShijishiyong() {
        return yanshouGongyiShijishiyong;
    }
    /**
	 * 设置：实际使用
	 */

    public void setYanshouGongyiShijishiyong(String yanshouGongyiShijishiyong) {
        this.yanshouGongyiShijishiyong = yanshouGongyiShijishiyong;
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
	 * 获取：备注
	 */
    public String getYanshouGongyiContent() {
        return yanshouGongyiContent;
    }
    /**
	 * 设置：备注
	 */

    public void setYanshouGongyiContent(String yanshouGongyiContent) {
        this.yanshouGongyiContent = yanshouGongyiContent;
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
        return "YanshouGongyi{" +
            ", id=" + id +
            ", xiangmuId=" + xiangmuId +
            ", yuangongId=" + yuangongId +
            ", yanshouGongyiName=" + yanshouGongyiName +
            ", yanshouGongyiBuwei=" + yanshouGongyiBuwei +
            ", yanshouGongyiBiaozhun=" + yanshouGongyiBiaozhun +
            ", yanshouGongyiShijishiyong=" + yanshouGongyiShijishiyong +
            ", jianzaojinduFile=" + jianzaojinduFile +
            ", hegeTypes=" + hegeTypes +
            ", yanshouTime=" + DateUtil.convertString(yanshouTime,"yyyy-MM-dd") +
            ", yanshouGongyiContent=" + yanshouGongyiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
