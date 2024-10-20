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
 * 监造进度
 *
 * @author 
 * @email
 */
@TableName("jianzaojindu")
public class JianzaojinduEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianzaojinduEntity() {

	}

	public JianzaojinduEntity(T t) {
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
     * 监造进度编号
     */
    @ColumnInfo(comment="监造进度编号",type="varchar(200)")
    @TableField(value = "jianzaojindu_uuid_number")

    private String jianzaojinduUuidNumber;


    /**
     * 进度标题
     */
    @ColumnInfo(comment="进度标题",type="varchar(200)")
    @TableField(value = "jianzaojindu_name")

    private String jianzaojinduName;


    /**
     * 进度类型
     */
    @ColumnInfo(comment="进度类型",type="int(11)")
    @TableField(value = "jianzaojindu_types")

    private Integer jianzaojinduTypes;


    /**
     * 正常进度(%)
     */
    @ColumnInfo(comment="正常进度(%)",type="int(11)")
    @TableField(value = "jianzaojindu_zhengchang_number")

    private Integer jianzaojinduZhengchangNumber;


    /**
     * 现在进度(%)
     */
    @ColumnInfo(comment="现在进度(%)",type="int(11)")
    @TableField(value = "jianzaojindu_xianzai_number")

    private Integer jianzaojinduXianzaiNumber;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "jianzaojindu_file")

    private String jianzaojinduFile;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="记录时间",type="timestamp")
    @TableField(value = "jianzaojindu_time")

    private Date jianzaojinduTime;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="longtext")
    @TableField(value = "jianzaojindu_content")

    private String jianzaojinduContent;


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
	 * 获取：监造进度编号
	 */
    public String getJianzaojinduUuidNumber() {
        return jianzaojinduUuidNumber;
    }
    /**
	 * 设置：监造进度编号
	 */

    public void setJianzaojinduUuidNumber(String jianzaojinduUuidNumber) {
        this.jianzaojinduUuidNumber = jianzaojinduUuidNumber;
    }
    /**
	 * 获取：进度标题
	 */
    public String getJianzaojinduName() {
        return jianzaojinduName;
    }
    /**
	 * 设置：进度标题
	 */

    public void setJianzaojinduName(String jianzaojinduName) {
        this.jianzaojinduName = jianzaojinduName;
    }
    /**
	 * 获取：进度类型
	 */
    public Integer getJianzaojinduTypes() {
        return jianzaojinduTypes;
    }
    /**
	 * 设置：进度类型
	 */

    public void setJianzaojinduTypes(Integer jianzaojinduTypes) {
        this.jianzaojinduTypes = jianzaojinduTypes;
    }
    /**
	 * 获取：正常进度(%)
	 */
    public Integer getJianzaojinduZhengchangNumber() {
        return jianzaojinduZhengchangNumber;
    }
    /**
	 * 设置：正常进度(%)
	 */

    public void setJianzaojinduZhengchangNumber(Integer jianzaojinduZhengchangNumber) {
        this.jianzaojinduZhengchangNumber = jianzaojinduZhengchangNumber;
    }
    /**
	 * 获取：现在进度(%)
	 */
    public Integer getJianzaojinduXianzaiNumber() {
        return jianzaojinduXianzaiNumber;
    }
    /**
	 * 设置：现在进度(%)
	 */

    public void setJianzaojinduXianzaiNumber(Integer jianzaojinduXianzaiNumber) {
        this.jianzaojinduXianzaiNumber = jianzaojinduXianzaiNumber;
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
	 * 获取：记录时间
	 */
    public Date getJianzaojinduTime() {
        return jianzaojinduTime;
    }
    /**
	 * 设置：记录时间
	 */

    public void setJianzaojinduTime(Date jianzaojinduTime) {
        this.jianzaojinduTime = jianzaojinduTime;
    }
    /**
	 * 获取：备注
	 */
    public String getJianzaojinduContent() {
        return jianzaojinduContent;
    }
    /**
	 * 设置：备注
	 */

    public void setJianzaojinduContent(String jianzaojinduContent) {
        this.jianzaojinduContent = jianzaojinduContent;
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
        return "Jianzaojindu{" +
            ", id=" + id +
            ", xiangmuId=" + xiangmuId +
            ", yuangongId=" + yuangongId +
            ", jianzaojinduUuidNumber=" + jianzaojinduUuidNumber +
            ", jianzaojinduName=" + jianzaojinduName +
            ", jianzaojinduTypes=" + jianzaojinduTypes +
            ", jianzaojinduZhengchangNumber=" + jianzaojinduZhengchangNumber +
            ", jianzaojinduXianzaiNumber=" + jianzaojinduXianzaiNumber +
            ", jianzaojinduFile=" + jianzaojinduFile +
            ", jianzaojinduTime=" + DateUtil.convertString(jianzaojinduTime,"yyyy-MM-dd") +
            ", jianzaojinduContent=" + jianzaojinduContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
