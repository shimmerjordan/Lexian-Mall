package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.CategoryCommodity;
import com.neu.quickapp.pojo.CategoryCommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryCommodityMapper {
    int countByExample(CategoryCommodityExample example);

    int deleteByExample(CategoryCommodityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryCommodity record);

    int insertSelective(CategoryCommodity record);

    List<CategoryCommodity> selectByExample(CategoryCommodityExample example);

    CategoryCommodity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryCommodity record, @Param("example") CategoryCommodityExample example);

    int updateByExample(@Param("record") CategoryCommodity record, @Param("example") CategoryCommodityExample example);

    int updateByPrimaryKeySelective(CategoryCommodity record);

    int updateByPrimaryKey(CategoryCommodity record);
}