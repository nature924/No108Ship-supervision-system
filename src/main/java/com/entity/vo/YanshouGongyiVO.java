package com.entity.vo;

import com.entity.YanshouGongyiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工艺验收
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yanshou_gongyi")
public class YanshouGongyiVO implements Serializable {
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
     * 工艺名称
     */

    @TableField(value = "yanshou_gongyi_name")
    private String yanshouGongyiName;


    /**
     * 验收部位
     */

    @TableField(value = "yanshou_gongyi_buwei")
    private String yanshouGongyiBuwei;


    /**
     * 使用标准
     */

    @TableField(value = "yanshou_gongyi_biaozhun")
    private String yanshouGongyiBiaozhun;


    /**
     * 实际使用
     */

    @TableField(value = "yanshou_gongyi_shijishiyong")
    private String yanshouGongyiShijishiyong;


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

    @TableField(value = "yanshou_gongyi_content")
    private String yanshouGongyiContent;


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
	 * 设置：工艺名称
	 */
    public String getYanshouGongyiName() {
        return yanshouGongyiName;
    }


    /**
	 * 获取：工艺名称
	 */

    public void setYanshouGongyiName(String yanshouGongyiName) {
        this.yanshouGongyiName = yanshouGongyiName;
    }
    /**
	 * 设置：验收部位
	 */
    public String getYanshouGongyiBuwei() {
        return yanshouGongyiBuwei;
    }


    /**
	 * 获取：验收部位
	 */

    public void setYanshouGongyiBuwei(String yanshouGongyiBuwei) {
        this.yanshouGongyiBuwei = yanshouGongyiBuwei;
    }
    /**
	 * 设置：使用标准
	 */
    public String getYanshouGongyiBiaozhun() {
        return yanshouGongyiBiaozhun;
    }


    /**
	 * 获取：使用标准
	 */

    public void setYanshouGongyiBiaozhun(String yanshouGongyiBiaozhun) {
        this.yanshouGongyiBiaozhun = yanshouGongyiBiaozhun;
    }
    /**
	 * 设置：实际使用
	 */
    public String getYanshouGongyiShijishiyong() {
        return yanshouGongyiShijishiyong;
    }


    /**
	 * 获取：实际使用
	 */

    public void setYanshouGongyiShijishiyong(String yanshouGongyiShijishiyong) {
        this.yanshouGongyiShijishiyong = yanshouGongyiShijishiyong;
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
    public String getYanshouGongyiContent() {
        return yanshouGongyiContent;
    }


    /**
	 * 获取：备注
	 */

    public void setYanshouGongyiContent(String yanshouGongyiContent) {
        this.yanshouGongyiContent = yanshouGongyiContent;
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
