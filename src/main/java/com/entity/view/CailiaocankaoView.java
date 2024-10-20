package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.CailiaocankaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 材料参考
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("cailiaocankao")
public class CailiaocankaoView extends CailiaocankaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 材料类型的值
	*/
	@ColumnInfo(comment="材料类型的字典表值",type="varchar(200)")
	private String cailiaoValue;




	public CailiaocankaoView() {

	}

	public CailiaocankaoView(CailiaocankaoEntity cailiaocankaoEntity) {
		try {
			BeanUtils.copyProperties(this, cailiaocankaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 材料类型的值
	*/
	public String getCailiaoValue() {
		return cailiaoValue;
	}
	/**
	* 设置： 材料类型的值
	*/
	public void setCailiaoValue(String cailiaoValue) {
		this.cailiaoValue = cailiaoValue;
	}




	@Override
	public String toString() {
		return "CailiaocankaoView{" +
			", cailiaoValue=" + cailiaoValue +
			"} " + super.toString();
	}
}
