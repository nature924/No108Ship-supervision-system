package com.entity.model;

import com.entity.YanshouChengguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 成果验收
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YanshouChengguoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目
     */
    private Integer xiangmuId;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 验收部位
     */
    private String yanshouChengguoBuwei;


    /**
     * 船东要求
     */
    private String yanshouChengguoChuandong;


    /**
     * 实际结果
     */
    private String yanshouChengguoShiji;


    /**
     * 附件
     */
    private String jianzaojinduFile;


    /**
     * 是否合格
     */
    private Integer hegeTypes;


    /**
     * 验收时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yanshouTime;


    /**
     * 缘由
     */
    private String yanshouChengguoContent;


    /**
     * 备注
     */
    private String yanshouChengguoBeizhuContent;


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

    }
