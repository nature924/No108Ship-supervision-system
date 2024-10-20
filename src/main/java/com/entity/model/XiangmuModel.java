package com.entity.model;

import com.entity.XiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 项目编号
     */
    private String xiangmuUuidNumber;


    /**
     * 项目名称
     */
    private String xiangmuName;


    /**
     * 监造地点
     */
    private String xiangmuAddress;


    /**
     * 建造资料
     */
    private String xiangmuFile;


    /**
     * 项目类型
     */
    private Integer xiangmuTypes;


    /**
     * 监造数量
     */
    private Integer xiangmuKucunNumber;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shenqingTime;


    /**
     * 拿船时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date nachuanTime;


    /**
     * 监造要求
     */
    private String xiangmuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
