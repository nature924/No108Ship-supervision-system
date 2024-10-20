package com.entity.vo;

import com.entity.XiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmu")
public class XiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 项目编号
     */

    @TableField(value = "xiangmu_uuid_number")
    private String xiangmuUuidNumber;


    /**
     * 项目名称
     */

    @TableField(value = "xiangmu_name")
    private String xiangmuName;


    /**
     * 监造地点
     */

    @TableField(value = "xiangmu_address")
    private String xiangmuAddress;


    /**
     * 建造资料
     */

    @TableField(value = "xiangmu_file")
    private String xiangmuFile;


    /**
     * 项目类型
     */

    @TableField(value = "xiangmu_types")
    private Integer xiangmuTypes;


    /**
     * 监造数量
     */

    @TableField(value = "xiangmu_kucun_number")
    private Integer xiangmuKucunNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shenqing_time")
    private Date shenqingTime;


    /**
     * 拿船时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "nachuan_time")
    private Date nachuanTime;


    /**
     * 监造要求
     */

    @TableField(value = "xiangmu_content")
    private String xiangmuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：项目编号
	 */
    public String getXiangmuUuidNumber() {
        return xiangmuUuidNumber;
    }


    /**
	 * 获取：项目编号
	 */

    public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
        this.xiangmuUuidNumber = xiangmuUuidNumber;
    }
    /**
	 * 设置：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }


    /**
	 * 获取：项目名称
	 */

    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 设置：监造地点
	 */
    public String getXiangmuAddress() {
        return xiangmuAddress;
    }


    /**
	 * 获取：监造地点
	 */

    public void setXiangmuAddress(String xiangmuAddress) {
        this.xiangmuAddress = xiangmuAddress;
    }
    /**
	 * 设置：建造资料
	 */
    public String getXiangmuFile() {
        return xiangmuFile;
    }


    /**
	 * 获取：建造资料
	 */

    public void setXiangmuFile(String xiangmuFile) {
        this.xiangmuFile = xiangmuFile;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }


    /**
	 * 获取：项目类型
	 */

    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 设置：监造数量
	 */
    public Integer getXiangmuKucunNumber() {
        return xiangmuKucunNumber;
    }


    /**
	 * 获取：监造数量
	 */

    public void setXiangmuKucunNumber(Integer xiangmuKucunNumber) {
        this.xiangmuKucunNumber = xiangmuKucunNumber;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getShenqingTime() {
        return shenqingTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setShenqingTime(Date shenqingTime) {
        this.shenqingTime = shenqingTime;
    }
    /**
	 * 设置：拿船时间
	 */
    public Date getNachuanTime() {
        return nachuanTime;
    }


    /**
	 * 获取：拿船时间
	 */

    public void setNachuanTime(Date nachuanTime) {
        this.nachuanTime = nachuanTime;
    }
    /**
	 * 设置：监造要求
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }


    /**
	 * 获取：监造要求
	 */

    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
