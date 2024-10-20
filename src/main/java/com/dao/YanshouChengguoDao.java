package com.dao;

import com.entity.YanshouChengguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YanshouChengguoView;

/**
 * 成果验收 Dao 接口
 *
 * @author 
 */
public interface YanshouChengguoDao extends BaseMapper<YanshouChengguoEntity> {

   List<YanshouChengguoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
