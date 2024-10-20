package com.entity.vo;

import com.entity.XiangmuTuzhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目图纸
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmu_tuzhi")
public class XiangmuTuzhiVO implements Serializable {
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
     * 图纸编号
     */

    @TableField(value = "xiangmu_tuzhi_uuid_number")
    private String xiangmuTuzhiUuidNumber;


    /**
     * 图纸名称
     */

    @TableField(value = "xiangmu_tuzhi_name")
    private String xiangmuTuzhiName;


    /**
     * 图纸文件
     */

    @TableField(value = "xiangmu_tuzhi_file")
    private String xiangmuTuzhiFile;


    /**
     * 图纸类型
     */

    @TableField(value = "xiangmu_tuzhi_types")
    private Integer xiangmuTuzhiTypes;


    /**
     * 图纸介绍
     */

    @TableField(value = "xiangmu_tuzhi_content")
    private String xiangmuTuzhiContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "xiangmu_tuzhi_yesno_types")
    private Integer xiangmuTuzhiYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "xiangmu_tuzhi_yesno_text")
    private String xiangmuTuzhiYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiangmu_tuzhi_shenhe_time")
    private Date xiangmuTuzhiShenheTime;


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
	 * 设置：图纸编号
	 */
    public String getXiangmuTuzhiUuidNumber() {
        return xiangmuTuzhiUuidNumber;
    }


    /**
	 * 获取：图纸编号
	 */

    public void setXiangmuTuzhiUuidNumber(String xiangmuTuzhiUuidNumber) {
        this.xiangmuTuzhiUuidNumber = xiangmuTuzhiUuidNumber;
    }
    /**
	 * 设置：图纸名称
	 */
    public String getXiangmuTuzhiName() {
        return xiangmuTuzhiName;
    }


    /**
	 * 获取：图纸名称
	 */

    public void setXiangmuTuzhiName(String xiangmuTuzhiName) {
        this.xiangmuTuzhiName = xiangmuTuzhiName;
    }
    /**
	 * 设置：图纸文件
	 */
    public String getXiangmuTuzhiFile() {
        return xiangmuTuzhiFile;
    }


    /**
	 * 获取：图纸文件
	 */

    public void setXiangmuTuzhiFile(String xiangmuTuzhiFile) {
        this.xiangmuTuzhiFile = xiangmuTuzhiFile;
    }
    /**
	 * 设置：图纸类型
	 */
    public Integer getXiangmuTuzhiTypes() {
        return xiangmuTuzhiTypes;
    }


    /**
	 * 获取：图纸类型
	 */

    public void setXiangmuTuzhiTypes(Integer xiangmuTuzhiTypes) {
        this.xiangmuTuzhiTypes = xiangmuTuzhiTypes;
    }
    /**
	 * 设置：图纸介绍
	 */
    public String getXiangmuTuzhiContent() {
        return xiangmuTuzhiContent;
    }


    /**
	 * 获取：图纸介绍
	 */

    public void setXiangmuTuzhiContent(String xiangmuTuzhiContent) {
        this.xiangmuTuzhiContent = xiangmuTuzhiContent;
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
	 * 设置：申请状态
	 */
    public Integer getXiangmuTuzhiYesnoTypes() {
        return xiangmuTuzhiYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setXiangmuTuzhiYesnoTypes(Integer xiangmuTuzhiYesnoTypes) {
        this.xiangmuTuzhiYesnoTypes = xiangmuTuzhiYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getXiangmuTuzhiYesnoText() {
        return xiangmuTuzhiYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setXiangmuTuzhiYesnoText(String xiangmuTuzhiYesnoText) {
        this.xiangmuTuzhiYesnoText = xiangmuTuzhiYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getXiangmuTuzhiShenheTime() {
        return xiangmuTuzhiShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setXiangmuTuzhiShenheTime(Date xiangmuTuzhiShenheTime) {
        this.xiangmuTuzhiShenheTime = xiangmuTuzhiShenheTime;
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
