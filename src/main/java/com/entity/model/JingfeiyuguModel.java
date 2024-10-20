package com.entity.model;

import com.entity.JingfeiyuguEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 经费预估
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JingfeiyuguModel implements Serializable {
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
     * 经费预估编号
     */
    private String jingfeiyuguUuidNumber;


    /**
     * 材料名称
     */
    private String jingfeiyuguName;


    /**
     * 单价单位
     */
    private String jingfeiyuguDanwei;


    /**
     * 材料单价
     */
    private Double jingfeiyuguDanjia;


    /**
     * 材料类型
     */
    private Integer cailiaoTypes;


    /**
     * 所需数量
     */
    private Integer jingfeiyuguNumber;


    /**
     * 预计总价
     */
    private Double jingfeiyuguZongjia;


    /**
     * 推荐公司
     */
    private String jingfeiyuguGongsi;


    /**
     * 执行标准
     */
    private String jingfeiyuguFile;


    /**
     * 备注
     */
    private String jingfeiyuguContent;


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
	 * 获取：经费预估编号
	 */
    public String getJingfeiyuguUuidNumber() {
        return jingfeiyuguUuidNumber;
    }


    /**
	 * 设置：经费预估编号
	 */
    public void setJingfeiyuguUuidNumber(String jingfeiyuguUuidNumber) {
        this.jingfeiyuguUuidNumber = jingfeiyuguUuidNumber;
    }
    /**
	 * 获取：材料名称
	 */
    public String getJingfeiyuguName() {
        return jingfeiyuguName;
    }


    /**
	 * 设置：材料名称
	 */
    public void setJingfeiyuguName(String jingfeiyuguName) {
        this.jingfeiyuguName = jingfeiyuguName;
    }
    /**
	 * 获取：单价单位
	 */
    public String getJingfeiyuguDanwei() {
        return jingfeiyuguDanwei;
    }


    /**
	 * 设置：单价单位
	 */
    public void setJingfeiyuguDanwei(String jingfeiyuguDanwei) {
        this.jingfeiyuguDanwei = jingfeiyuguDanwei;
    }
    /**
	 * 获取：材料单价
	 */
    public Double getJingfeiyuguDanjia() {
        return jingfeiyuguDanjia;
    }


    /**
	 * 设置：材料单价
	 */
    public void setJingfeiyuguDanjia(Double jingfeiyuguDanjia) {
        this.jingfeiyuguDanjia = jingfeiyuguDanjia;
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
	 * 获取：所需数量
	 */
    public Integer getJingfeiyuguNumber() {
        return jingfeiyuguNumber;
    }


    /**
	 * 设置：所需数量
	 */
    public void setJingfeiyuguNumber(Integer jingfeiyuguNumber) {
        this.jingfeiyuguNumber = jingfeiyuguNumber;
    }
    /**
	 * 获取：预计总价
	 */
    public Double getJingfeiyuguZongjia() {
        return jingfeiyuguZongjia;
    }


    /**
	 * 设置：预计总价
	 */
    public void setJingfeiyuguZongjia(Double jingfeiyuguZongjia) {
        this.jingfeiyuguZongjia = jingfeiyuguZongjia;
    }
    /**
	 * 获取：推荐公司
	 */
    public String getJingfeiyuguGongsi() {
        return jingfeiyuguGongsi;
    }


    /**
	 * 设置：推荐公司
	 */
    public void setJingfeiyuguGongsi(String jingfeiyuguGongsi) {
        this.jingfeiyuguGongsi = jingfeiyuguGongsi;
    }
    /**
	 * 获取：执行标准
	 */
    public String getJingfeiyuguFile() {
        return jingfeiyuguFile;
    }


    /**
	 * 设置：执行标准
	 */
    public void setJingfeiyuguFile(String jingfeiyuguFile) {
        this.jingfeiyuguFile = jingfeiyuguFile;
    }
    /**
	 * 获取：备注
	 */
    public String getJingfeiyuguContent() {
        return jingfeiyuguContent;
    }


    /**
	 * 设置：备注
	 */
    public void setJingfeiyuguContent(String jingfeiyuguContent) {
        this.jingfeiyuguContent = jingfeiyuguContent;
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
