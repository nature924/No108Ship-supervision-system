package com.entity.model;

import com.entity.XiangmuTuzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目图纸
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuTuzhiModel implements Serializable {
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
     * 图纸编号
     */
    private String xiangmuTuzhiUuidNumber;


    /**
     * 图纸名称
     */
    private String xiangmuTuzhiName;


    /**
     * 图纸文件
     */
    private String xiangmuTuzhiFile;


    /**
     * 图纸类型
     */
    private Integer xiangmuTuzhiTypes;


    /**
     * 图纸介绍
     */
    private String xiangmuTuzhiContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请状态
     */
    private Integer xiangmuTuzhiYesnoTypes;


    /**
     * 审核回复
     */
    private String xiangmuTuzhiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiangmuTuzhiShenheTime;


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
	 * 获取：图纸编号
	 */
    public String getXiangmuTuzhiUuidNumber() {
        return xiangmuTuzhiUuidNumber;
    }


    /**
	 * 设置：图纸编号
	 */
    public void setXiangmuTuzhiUuidNumber(String xiangmuTuzhiUuidNumber) {
        this.xiangmuTuzhiUuidNumber = xiangmuTuzhiUuidNumber;
    }
    /**
	 * 获取：图纸名称
	 */
    public String getXiangmuTuzhiName() {
        return xiangmuTuzhiName;
    }


    /**
	 * 设置：图纸名称
	 */
    public void setXiangmuTuzhiName(String xiangmuTuzhiName) {
        this.xiangmuTuzhiName = xiangmuTuzhiName;
    }
    /**
	 * 获取：图纸文件
	 */
    public String getXiangmuTuzhiFile() {
        return xiangmuTuzhiFile;
    }


    /**
	 * 设置：图纸文件
	 */
    public void setXiangmuTuzhiFile(String xiangmuTuzhiFile) {
        this.xiangmuTuzhiFile = xiangmuTuzhiFile;
    }
    /**
	 * 获取：图纸类型
	 */
    public Integer getXiangmuTuzhiTypes() {
        return xiangmuTuzhiTypes;
    }


    /**
	 * 设置：图纸类型
	 */
    public void setXiangmuTuzhiTypes(Integer xiangmuTuzhiTypes) {
        this.xiangmuTuzhiTypes = xiangmuTuzhiTypes;
    }
    /**
	 * 获取：图纸介绍
	 */
    public String getXiangmuTuzhiContent() {
        return xiangmuTuzhiContent;
    }


    /**
	 * 设置：图纸介绍
	 */
    public void setXiangmuTuzhiContent(String xiangmuTuzhiContent) {
        this.xiangmuTuzhiContent = xiangmuTuzhiContent;
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
	 * 获取：申请状态
	 */
    public Integer getXiangmuTuzhiYesnoTypes() {
        return xiangmuTuzhiYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setXiangmuTuzhiYesnoTypes(Integer xiangmuTuzhiYesnoTypes) {
        this.xiangmuTuzhiYesnoTypes = xiangmuTuzhiYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getXiangmuTuzhiYesnoText() {
        return xiangmuTuzhiYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setXiangmuTuzhiYesnoText(String xiangmuTuzhiYesnoText) {
        this.xiangmuTuzhiYesnoText = xiangmuTuzhiYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getXiangmuTuzhiShenheTime() {
        return xiangmuTuzhiShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setXiangmuTuzhiShenheTime(Date xiangmuTuzhiShenheTime) {
        this.xiangmuTuzhiShenheTime = xiangmuTuzhiShenheTime;
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
