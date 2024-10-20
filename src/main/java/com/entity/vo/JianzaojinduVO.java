package com.entity.vo;

import com.entity.JianzaojinduEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 监造进度
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianzaojindu")
public class JianzaojinduVO implements Serializable {
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
     * 监造进度编号
     */

    @TableField(value = "jianzaojindu_uuid_number")
    private String jianzaojinduUuidNumber;


    /**
     * 进度标题
     */

    @TableField(value = "jianzaojindu_name")
    private String jianzaojinduName;


    /**
     * 进度类型
     */

    @TableField(value = "jianzaojindu_types")
    private Integer jianzaojinduTypes;


    /**
     * 正常进度(%)
     */

    @TableField(value = "jianzaojindu_zhengchang_number")
    private Integer jianzaojinduZhengchangNumber;


    /**
     * 现在进度(%)
     */

    @TableField(value = "jianzaojindu_xianzai_number")
    private Integer jianzaojinduXianzaiNumber;


    /**
     * 附件
     */

    @TableField(value = "jianzaojindu_file")
    private String jianzaojinduFile;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jianzaojindu_time")
    private Date jianzaojinduTime;


    /**
     * 备注
     */

    @TableField(value = "jianzaojindu_content")
    private String jianzaojinduContent;


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
	 * 设置：监造进度编号
	 */
    public String getJianzaojinduUuidNumber() {
        return jianzaojinduUuidNumber;
    }


    /**
	 * 获取：监造进度编号
	 */

    public void setJianzaojinduUuidNumber(String jianzaojinduUuidNumber) {
        this.jianzaojinduUuidNumber = jianzaojinduUuidNumber;
    }
    /**
	 * 设置：进度标题
	 */
    public String getJianzaojinduName() {
        return jianzaojinduName;
    }


    /**
	 * 获取：进度标题
	 */

    public void setJianzaojinduName(String jianzaojinduName) {
        this.jianzaojinduName = jianzaojinduName;
    }
    /**
	 * 设置：进度类型
	 */
    public Integer getJianzaojinduTypes() {
        return jianzaojinduTypes;
    }


    /**
	 * 获取：进度类型
	 */

    public void setJianzaojinduTypes(Integer jianzaojinduTypes) {
        this.jianzaojinduTypes = jianzaojinduTypes;
    }
    /**
	 * 设置：正常进度(%)
	 */
    public Integer getJianzaojinduZhengchangNumber() {
        return jianzaojinduZhengchangNumber;
    }


    /**
	 * 获取：正常进度(%)
	 */

    public void setJianzaojinduZhengchangNumber(Integer jianzaojinduZhengchangNumber) {
        this.jianzaojinduZhengchangNumber = jianzaojinduZhengchangNumber;
    }
    /**
	 * 设置：现在进度(%)
	 */
    public Integer getJianzaojinduXianzaiNumber() {
        return jianzaojinduXianzaiNumber;
    }


    /**
	 * 获取：现在进度(%)
	 */

    public void setJianzaojinduXianzaiNumber(Integer jianzaojinduXianzaiNumber) {
        this.jianzaojinduXianzaiNumber = jianzaojinduXianzaiNumber;
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
	 * 设置：记录时间
	 */
    public Date getJianzaojinduTime() {
        return jianzaojinduTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setJianzaojinduTime(Date jianzaojinduTime) {
        this.jianzaojinduTime = jianzaojinduTime;
    }
    /**
	 * 设置：备注
	 */
    public String getJianzaojinduContent() {
        return jianzaojinduContent;
    }


    /**
	 * 获取：备注
	 */

    public void setJianzaojinduContent(String jianzaojinduContent) {
        this.jianzaojinduContent = jianzaojinduContent;
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
