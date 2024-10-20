package com.entity.vo;

import com.entity.CailiaocankaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 材料参考
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cailiaocankao")
public class CailiaocankaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 材料编号
     */

    @TableField(value = "cailiaocankao_uuid_number")
    private String cailiaocankaoUuidNumber;


    /**
     * 材料名称
     */

    @TableField(value = "cailiaocankao_name")
    private String cailiaocankaoName;


    /**
     * 材料类型
     */

    @TableField(value = "cailiao_types")
    private Integer cailiaoTypes;


    /**
     * 单价单位
     */

    @TableField(value = "cailiaocankao_danwei")
    private String cailiaocankaoDanwei;


    /**
     * 参考单价
     */

    @TableField(value = "cailiaocankao_danjia")
    private Double cailiaocankaoDanjia;


    /**
     * 材料规格
     */

    @TableField(value = "cailiaocankao_guige")
    private String cailiaocankaoGuige;


    /**
     * 执行标准
     */

    @TableField(value = "cailiaocankao_file")
    private String cailiaocankaoFile;


    /**
     * 推荐公司
     */

    @TableField(value = "cailiaocankao_gongsi")
    private String cailiaocankaoGongsi;


    /**
     * 备注
     */

    @TableField(value = "cailiaocankao_content")
    private String cailiaocankaoContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：材料编号
	 */
    public String getCailiaocankaoUuidNumber() {
        return cailiaocankaoUuidNumber;
    }


    /**
	 * 获取：材料编号
	 */

    public void setCailiaocankaoUuidNumber(String cailiaocankaoUuidNumber) {
        this.cailiaocankaoUuidNumber = cailiaocankaoUuidNumber;
    }
    /**
	 * 设置：材料名称
	 */
    public String getCailiaocankaoName() {
        return cailiaocankaoName;
    }


    /**
	 * 获取：材料名称
	 */

    public void setCailiaocankaoName(String cailiaocankaoName) {
        this.cailiaocankaoName = cailiaocankaoName;
    }
    /**
	 * 设置：材料类型
	 */
    public Integer getCailiaoTypes() {
        return cailiaoTypes;
    }


    /**
	 * 获取：材料类型
	 */

    public void setCailiaoTypes(Integer cailiaoTypes) {
        this.cailiaoTypes = cailiaoTypes;
    }
    /**
	 * 设置：单价单位
	 */
    public String getCailiaocankaoDanwei() {
        return cailiaocankaoDanwei;
    }


    /**
	 * 获取：单价单位
	 */

    public void setCailiaocankaoDanwei(String cailiaocankaoDanwei) {
        this.cailiaocankaoDanwei = cailiaocankaoDanwei;
    }
    /**
	 * 设置：参考单价
	 */
    public Double getCailiaocankaoDanjia() {
        return cailiaocankaoDanjia;
    }


    /**
	 * 获取：参考单价
	 */

    public void setCailiaocankaoDanjia(Double cailiaocankaoDanjia) {
        this.cailiaocankaoDanjia = cailiaocankaoDanjia;
    }
    /**
	 * 设置：材料规格
	 */
    public String getCailiaocankaoGuige() {
        return cailiaocankaoGuige;
    }


    /**
	 * 获取：材料规格
	 */

    public void setCailiaocankaoGuige(String cailiaocankaoGuige) {
        this.cailiaocankaoGuige = cailiaocankaoGuige;
    }
    /**
	 * 设置：执行标准
	 */
    public String getCailiaocankaoFile() {
        return cailiaocankaoFile;
    }


    /**
	 * 获取：执行标准
	 */

    public void setCailiaocankaoFile(String cailiaocankaoFile) {
        this.cailiaocankaoFile = cailiaocankaoFile;
    }
    /**
	 * 设置：推荐公司
	 */
    public String getCailiaocankaoGongsi() {
        return cailiaocankaoGongsi;
    }


    /**
	 * 获取：推荐公司
	 */

    public void setCailiaocankaoGongsi(String cailiaocankaoGongsi) {
        this.cailiaocankaoGongsi = cailiaocankaoGongsi;
    }
    /**
	 * 设置：备注
	 */
    public String getCailiaocankaoContent() {
        return cailiaocankaoContent;
    }


    /**
	 * 获取：备注
	 */

    public void setCailiaocankaoContent(String cailiaocankaoContent) {
        this.cailiaocankaoContent = cailiaocankaoContent;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
