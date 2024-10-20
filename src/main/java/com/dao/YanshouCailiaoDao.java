package com.dao;

import com.entity.YanshouCailiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YanshouCailiaoView;

/**
 * 材料验收 Dao 接口
 *
 * @author 
 */
public interface YanshouCailiaoDao extends BaseMapper<YanshouCailiaoEntity> {

   List<YanshouCailiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
