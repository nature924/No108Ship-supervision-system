package com.entity.vo;

import com.entity.JianzaocaiwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 监造财务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianzaocaiwu")
public class JianzaocaiwuVO implements Serializable {
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
     * 监造财务编号
     */

    @TableField(value = "jianzaocaiwu_uuid_number")
    private String jianzaocaiwuUuidNumber;


    /**
     * 花费标题
     */

    @TableField(value = "jianzaocaiwu_name")
    private String jianzaocaiwuName;


    /**
     * 消费类型
     */

    @TableField(value = "jianzaocaiwu_types")
    private Integer jianzaocaiwuTypes;


    /**
     * 附件
     */

    @TableField(value = "jianzaojindu_file")
    private String jianzaojinduFile;


    /**
     * 名称
     */

    @TableField(value = "jianzaocaiwu_mingcheng")
    private String jianzaocaiwuMingcheng;


    /**
     * 单价
     */

    @TableField(value = "jianzaocaiwu_danjia")
    private Double jianzaocaiwuDanjia;


    /**
     * 数量
     */

    @TableField(value = "jianzaocaiwu_number")
    private Integer jianzaocaiwuNumber;


    /**
     * 应金额
     */

    @TableField(value = "jianzaocaiwu_zongjine")
    private Double jianzaocaiwuZongjine;


    /**
     * 实际金额
     */

    @TableField(value = "jianzaocaiwu_shiji_zongjine")
    private Double jianzaocaiwuShijiZongjine;


    /**
     * 是否合格
     */

    @TableField(value = "hege_types")
    private Integer hegeTypes;


    /**
     * 备注
     */

    @TableField(value = "jianzaocaiwu_content")
    private String jianzaocaiwuContent;


    /**
     * 验收时间
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
	 * 设置：监造财务编号
	 */
    public String getJianzaocaiwuUuidNumber() {
        return jianzaocaiwuUuidNumber;
    }


    /**
	 * 获取：监造财务编号
	 */

    public void setJianzaocaiwuUuidNumber(String jianzaocaiwuUuidNumber) {
        this.jianzaocaiwuUuidNumber = jianzaocaiwuUuidNumber;
    }
    /**
	 * 设置：花费标题
	 */
    public String getJianzaocaiwuName() {
        return jianzaocaiwuName;
    }


    /**
	 * 获取：花费标题
	 */

    public void setJianzaocaiwuName(String jianzaocaiwuName) {
        this.jianzaocaiwuName = jianzaocaiwuName;
    }
    /**
	 * 设置：消费类型
	 */
    public Integer getJianzaocaiwuTypes() {
        return jianzaocaiwuTypes;
    }


    /**
	 * 获取：消费类型
	 */

    public void setJianzaocaiwuTypes(Integer jianzaocaiwuTypes) {
        this.jianzaocaiwuTypes = jianzaocaiwuTypes;
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
	 * 设置：名称
	 */
    public String getJianzaocaiwuMingcheng() {
        return jianzaocaiwuMingcheng;
    }


    /**
	 * 获取：名称
	 */

    public void setJianzaocaiwuMingcheng(String jianzaocaiwuMingcheng) {
        this.jianzaocaiwuMingcheng = jianzaocaiwuMingcheng;
    }
    /**
	 * 设置：单价
	 */
    public Double getJianzaocaiwuDanjia() {
        return jianzaocaiwuDanjia;
    }


    /**
	 * 获取：单价
	 */

    public void setJianzaocaiwuDanjia(Double jianzaocaiwuDanjia) {
        this.jianzaocaiwuDanjia = jianzaocaiwuDanjia;
    }
    /**
	 * 设置：数量
	 */
    public Integer getJianzaocaiwuNumber() {
        return jianzaocaiwuNumber;
    }


    /**
	 * 获取：数量
	 */

    public void setJianzaocaiwuNumber(Integer jianzaocaiwuNumber) {
        this.jianzaocaiwuNumber = jianzaocaiwuNumber;
    }
    /**
	 * 设置：应金额
	 */
    public Double getJianzaocaiwuZongjine() {
        return jianzaocaiwuZongjine;
    }


    /**
	 * 获取：应金额
	 */

    public void setJianzaocaiwuZongjine(Double jianzaocaiwuZongjine) {
        this.jianzaocaiwuZongjine = jianzaocaiwuZongjine;
    }
    /**
	 * 设置：实际金额
	 */
    public Double getJianzaocaiwuShijiZongjine() {
        return jianzaocaiwuShijiZongjine;
    }


    /**
	 * 获取：实际金额
	 */

    public void setJianzaocaiwuShijiZongjine(Double jianzaocaiwuShijiZongjine) {
        this.jianzaocaiwuShijiZongjine = jianzaocaiwuShijiZongjine;
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
	 * 设置：备注
	 */
    public String getJianzaocaiwuContent() {
        return jianzaocaiwuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setJianzaocaiwuContent(String jianzaocaiwuContent) {
        this.jianzaocaiwuContent = jianzaocaiwuContent;
    }
    /**
	 * 设置：验收时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：验收时间
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
