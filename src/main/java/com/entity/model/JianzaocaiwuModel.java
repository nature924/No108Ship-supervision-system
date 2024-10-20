package com.entity.model;

import com.entity.JianzaocaiwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 监造财务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianzaocaiwuModel implements Serializable {
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
     * 监造财务编号
     */
    private String jianzaocaiwuUuidNumber;


    /**
     * 花费标题
     */
    private String jianzaocaiwuName;


    /**
     * 消费类型
     */
    private Integer jianzaocaiwuTypes;


    /**
     * 附件
     */
    private String jianzaojinduFile;


    /**
     * 名称
     */
    private String jianzaocaiwuMingcheng;


    /**
     * 单价
     */
    private Double jianzaocaiwuDanjia;


    /**
     * 数量
     */
    private Integer jianzaocaiwuNumber;


    /**
     * 应金额
     */
    private Double jianzaocaiwuZongjine;


    /**
     * 实际金额
     */
    private Double jianzaocaiwuShijiZongjine;


    /**
     * 是否合格
     */
    private Integer hegeTypes;


    /**
     * 备注
     */
    private String jianzaocaiwuContent;


    /**
     * 验收时间
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
	 * 获取：监造财务编号
	 */
    public String getJianzaocaiwuUuidNumber() {
        return jianzaocaiwuUuidNumber;
    }


    /**
	 * 设置：监造财务编号
	 */
    public void setJianzaocaiwuUuidNumber(String jianzaocaiwuUuidNumber) {
        this.jianzaocaiwuUuidNumber = jianzaocaiwuUuidNumber;
    }
    /**
	 * 获取：花费标题
	 */
    public String getJianzaocaiwuName() {
        return jianzaocaiwuName;
    }


    /**
	 * 设置：花费标题
	 */
    public void setJianzaocaiwuName(String jianzaocaiwuName) {
        this.jianzaocaiwuName = jianzaocaiwuName;
    }
    /**
	 * 获取：消费类型
	 */
    public Integer getJianzaocaiwuTypes() {
        return jianzaocaiwuTypes;
    }


    /**
	 * 设置：消费类型
	 */
    public void setJianzaocaiwuTypes(Integer jianzaocaiwuTypes) {
        this.jianzaocaiwuTypes = jianzaocaiwuTypes;
    }
    /**
	 * 获取：附件
	 */
    public String getJianzaojinduFile() {
        return jianzaojinduFile;
    }


    /**
	 * 设置：附件
	 */
    public void setJianzaojinduFile(String jianzaojinduFile) {
        this.jianzaojinduFile = jianzaojinduFile;
    }
    /**
	 * 获取：名称
	 */
    public String getJianzaocaiwuMingcheng() {
        return jianzaocaiwuMingcheng;
    }


    /**
	 * 设置：名称
	 */
    public void setJianzaocaiwuMingcheng(String jianzaocaiwuMingcheng) {
        this.jianzaocaiwuMingcheng = jianzaocaiwuMingcheng;
    }
    /**
	 * 获取：单价
	 */
    public Double getJianzaocaiwuDanjia() {
        return jianzaocaiwuDanjia;
    }


    /**
	 * 设置：单价
	 */
    public void setJianzaocaiwuDanjia(Double jianzaocaiwuDanjia) {
        this.jianzaocaiwuDanjia = jianzaocaiwuDanjia;
    }
    /**
	 * 获取：数量
	 */
    public Integer getJianzaocaiwuNumber() {
        return jianzaocaiwuNumber;
    }


    /**
	 * 设置：数量
	 */
    public void setJianzaocaiwuNumber(Integer jianzaocaiwuNumber) {
        this.jianzaocaiwuNumber = jianzaocaiwuNumber;
    }
    /**
	 * 获取：应金额
	 */
    public Double getJianzaocaiwuZongjine() {
        return jianzaocaiwuZongjine;
    }


    /**
	 * 设置：应金额
	 */
    public void setJianzaocaiwuZongjine(Double jianzaocaiwuZongjine) {
        this.jianzaocaiwuZongjine = jianzaocaiwuZongjine;
    }
    /**
	 * 获取：实际金额
	 */
    public Double getJianzaocaiwuShijiZongjine() {
        return jianzaocaiwuShijiZongjine;
    }


    /**
	 * 设置：实际金额
	 */
    public void setJianzaocaiwuShijiZongjine(Double jianzaocaiwuShijiZongjine) {
        this.jianzaocaiwuShijiZongjine = jianzaocaiwuShijiZongjine;
    }
    /**
	 * 获取：是否合格
	 */
    public Integer getHegeTypes() {
        return hegeTypes;
    }


    /**
	 * 设置：是否合格
	 */
    public void setHegeTypes(Integer hegeTypes) {
        this.hegeTypes = hegeTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getJianzaocaiwuContent() {
        return jianzaocaiwuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setJianzaocaiwuContent(String jianzaocaiwuContent) {
        this.jianzaocaiwuContent = jianzaocaiwuContent;
    }
    /**
	 * 获取：验收时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：验收时间
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
