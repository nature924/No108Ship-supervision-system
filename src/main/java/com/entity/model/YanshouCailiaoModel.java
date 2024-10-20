package com.entity.model;

import com.entity.YanshouCailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 材料验收
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YanshouCailiaoModel implements Serializable {
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
     * 材料名称
     */
    private String yanshouCailiaoName;


    /**
     * 监造部位
     */
    private String yanshouCailiaoBuwei;


    /**
     * 使用标准
     */
    private String yanshouCailiaoBiaozhun;


    /**
     * 实际使用
     */
    private String yanshouCailiaoShijishiyong;


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
     * 备注
     */
    private String yanshouCailiaoContent;


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
	 * 获取：材料名称
	 */
    public String getYanshouCailiaoName() {
        return yanshouCailiaoName;
    }


    /**
	 * 设置：材料名称
	 */
    public void setYanshouCailiaoName(String yanshouCailiaoName) {
        this.yanshouCailiaoName = yanshouCailiaoName;
    }
    /**
	 * 获取：监造部位
	 */
    public String getYanshouCailiaoBuwei() {
        return yanshouCailiaoBuwei;
    }


    /**
	 * 设置：监造部位
	 */
    public void setYanshouCailiaoBuwei(String yanshouCailiaoBuwei) {
        this.yanshouCailiaoBuwei = yanshouCailiaoBuwei;
    }
    /**
	 * 获取：使用标准
	 */
    public String getYanshouCailiaoBiaozhun() {
        return yanshouCailiaoBiaozhun;
    }


    /**
	 * 设置：使用标准
	 */
    public void setYanshouCailiaoBiaozhun(String yanshouCailiaoBiaozhun) {
        this.yanshouCailiaoBiaozhun = yanshouCailiaoBiaozhun;
    }
    /**
	 * 获取：实际使用
	 */
    public String getYanshouCailiaoShijishiyong() {
        return yanshouCailiaoShijishiyong;
    }


    /**
	 * 设置：实际使用
	 */
    public void setYanshouCailiaoShijishiyong(String yanshouCailiaoShijishiyong) {
        this.yanshouCailiaoShijishiyong = yanshouCailiaoShijishiyong;
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
    public String getYanshouCailiaoContent() {
        return yanshouCailiaoContent;
    }


    /**
	 * 设置：备注
	 */
    public void setYanshouCailiaoContent(String yanshouCailiaoContent) {
        this.yanshouCailiaoContent = yanshouCailiaoContent;
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
