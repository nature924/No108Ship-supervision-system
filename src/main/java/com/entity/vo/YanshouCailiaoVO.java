package com.entity.vo;

import com.entity.YanshouCailiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 材料验收
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yanshou_cailiao")
public class YanshouCailiaoVO implements Serializable {
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
     * 材料名称
     */

    @TableField(value = "yanshou_cailiao_name")
    private String yanshouCailiaoName;


    /**
     * 监造部位
     */

    @TableField(value = "yanshou_cailiao_buwei")
    private String yanshouCailiaoBuwei;


    /**
     * 使用标准
     */

    @TableField(value = "yanshou_cailiao_biaozhun")
    private String yanshouCailiaoBiaozhun;


    /**
     * 实际使用
     */

    @TableField(value = "yanshou_cailiao_shijishiyong")
    private String yanshouCailiaoShijishiyong;


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
     * 备注
     */

    @TableField(value = "yanshou_cailiao_content")
    private String yanshouCailiaoContent;


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
	 * 设置：材料名称
	 */
    public String getYanshouCailiaoName() {
        return yanshouCailiaoName;
    }


    /**
	 * 获取：材料名称
	 */

    public void setYanshouCailiaoName(String yanshouCailiaoName) {
        this.yanshouCailiaoName = yanshouCailiaoName;
    }
    /**
	 * 设置：监造部位
	 */
    public String getYanshouCailiaoBuwei() {
        return yanshouCailiaoBuwei;
    }


    /**
	 * 获取：监造部位
	 */

    public void setYanshouCailiaoBuwei(String yanshouCailiaoBuwei) {
        this.yanshouCailiaoBuwei = yanshouCailiaoBuwei;
    }
    /**
	 * 设置：使用标准
	 */
    public String getYanshouCailiaoBiaozhun() {
        return yanshouCailiaoBiaozhun;
    }


    /**
	 * 获取：使用标准
	 */

    public void setYanshouCailiaoBiaozhun(String yanshouCailiaoBiaozhun) {
        this.yanshouCailiaoBiaozhun = yanshouCailiaoBiaozhun;
    }
    /**
	 * 设置：实际使用
	 */
    public String getYanshouCailiaoShijishiyong() {
        return yanshouCailiaoShijishiyong;
    }


    /**
	 * 获取：实际使用
	 */

    public void setYanshouCailiaoShijishiyong(String yanshouCailiaoShijishiyong) {
        this.yanshouCailiaoShijishiyong = yanshouCailiaoShijishiyong;
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
	 * 设置：备注
	 */
    public String getYanshouCailiaoContent() {
        return yanshouCailiaoContent;
    }


    /**
	 * 获取：备注
	 */

    public void setYanshouCailiaoContent(String yanshouCailiaoContent) {
        this.yanshouCailiaoContent = yanshouCailiaoContent;
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
