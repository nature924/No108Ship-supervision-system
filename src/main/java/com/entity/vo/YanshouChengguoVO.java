package com.entity.vo;

import com.entity.YanshouChengguoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 成果验收
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yanshou_chengguo")
public class YanshouChengguoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 项目
     */

    @TableField(value = "xiangmu_id")
    private Integer xiangmuId;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 验收部位
     */

    @TableField(value = "yanshou_chengguo_buwei")
    private String yanshouChengguoBuwei;


    /**
     * 船东要求
     */

    @TableField(value = "yanshou_chengguo_chuandong")
    private String yanshouChengguoChuandong;


    /**
     * 实际结果
     */

    @TableField(value = "yanshou_chengguo_shiji")
    private String yanshouChengguoShiji;


    /**
     * 附件
     */

    @TableField(value = "jianzaojindu_file")
    private String jianzaojinduFile;


    /**
     * 是否合格
     */

    @TableField(value = "hege_types")
    private Integer hegeTypes;


    /**
     * 验收时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yanshou_time")
    private Date yanshouTime;


    /**
     * 缘由
     */

    @TableField(value = "yanshou_chengguo_content")
    private String yanshouChengguoContent;


    /**
     * 备注
     */

    @TableField(value = "yanshou_chengguo_beizhu_content")
    private String yanshouChengguoBeizhuContent;


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
	 * 设置：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 获取：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：验收部位
	 */
    public String getYanshouChengguoBuwei() {
        return yanshouChengguoBuwei;
    }


    /**
	 * 获取：验收部位
	 */

    public void setYanshouChengguoBuwei(String yanshouChengguoBuwei) {
        this.yanshouChengguoBuwei = yanshouChengguoBuwei;
    }
    /**
	 * 设置：船东要求
	 */
    public String getYanshouChengguoChuandong() {
        return yanshouChengguoChuandong;
    }


    /**
	 * 获取：船东要求
	 */

    public void setYanshouChengguoChuandong(String yanshouChengguoChuandong) {
        this.yanshouChengguoChuandong = yanshouChengguoChuandong;
    }
    /**
	 * 设置：实际结果
	 */
    public String getYanshouChengguoShiji() {
        return yanshouChengguoShiji;
    }


    /**
	 * 获取：实际结果
	 */

    public void setYanshouChengguoShiji(String yanshouChengguoShiji) {
        this.yanshouChengguoShiji = yanshouChengguoShiji;
    }
    /**
	 * 设置：附件
	 */
    public String getJianzaojinduFile() {
        return jianzaojinduFile;
    }


    /**
	 * 获取：附件
	 */

    public void setJianzaojinduFile(String jianzaojinduFile) {
        this.jianzaojinduFile = jianzaojinduFile;
    }
    /**
	 * 设置：是否合格
	 */
    public Integer getHegeTypes() {
        return hegeTypes;
    }


    /**
	 * 获取：是否合格
	 */

    public void setHegeTypes(Integer hegeTypes) {
        this.hegeTypes = hegeTypes;
    }
    /**
	 * 设置：验收时间
	 */
    public Date getYanshouTime() {
        return yanshouTime;
    }


    /**
	 * 获取：验收时间
	 */

    public void setYanshouTime(Date yanshouTime) {
        this.yanshouTime = yanshouTime;
    }
    /**
	 * 设置：缘由
	 */
    public String getYanshouChengguoContent() {
        return yanshouChengguoContent;
    }


    /**
	 * 获取：缘由
	 */

    public void setYanshouChengguoContent(String yanshouChengguoContent) {
        this.yanshouChengguoContent = yanshouChengguoContent;
    }
    /**
	 * 设置：备注
	 */
    public String getYanshouChengguoBeizhuContent() {
        return yanshouChengguoBeizhuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setYanshouChengguoBeizhuContent(String yanshouChengguoBeizhuContent) {
        this.yanshouChengguoBeizhuContent = yanshouChengguoBeizhuContent;
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
