package com.dao;

import com.entity.XiangmuTuzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuTuzhiView;

/**
 * 项目图纸 Dao 接口
 *
 * @author 
 */
public interface XiangmuTuzhiDao extends BaseMapper<XiangmuTuzhiEntity> {

   List<XiangmuTuzhiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
