package com.entity.model;

import com.entity.CailiaocankaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 材料参考
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CailiaocankaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 材料编号
     */
    private String cailiaocankaoUuidNumber;


    /**
     * 材料名称
     */
    private String cailiaocankaoName;


    /**
     * 材料类型
     */
    private Integer cailiaoTypes;


    /**
     * 单价单位
     */
    private String cailiaocankaoDanwei;


    /**
     * 参考单价
     */
    private Double cailiaocankaoDanjia;


    /**
     * 材料规格
     */
    private String cailiaocankaoGuige;


    /**
     * 执行标准
     */
    private String cailiaocankaoFile;


    /**
     * 推荐公司
     */
    private String cailiaocankaoGongsi;


    /**
     * 备注
     */
    private String cailiaocankaoContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
