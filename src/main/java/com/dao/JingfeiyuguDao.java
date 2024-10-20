package com.dao;

import com.entity.JingfeiyuguEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JingfeiyuguView;

/**
 * 经费预估 Dao 接口
 *
 * @author 
 */
public interface JingfeiyuguDao extends BaseMapper<JingfeiyuguEntity> {

   List<JingfeiyuguView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
