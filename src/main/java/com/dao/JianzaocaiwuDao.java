package com.dao;

import com.entity.JianzaocaiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianzaocaiwuView;

/**
 * 监造财务 Dao 接口
 *
 * @author 
 */
public interface JianzaocaiwuDao extends BaseMapper<JianzaocaiwuEntity> {

   List<JianzaocaiwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
