package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.ShopCommodity;
import com.neu.quickapp.pojo.ShopCommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCommodityMapper {
    int countByExample(ShopCommodityExample example);

    int deleteByExample(ShopCommodityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCommodity record);

    int insertSelective(ShopCommodity record);

    List<ShopCommodity> selectByExample(ShopCommodityExample example);

    ShopCommodity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopCommodity record, @Param("example") ShopCommodityExample example);

    int updateByExample(@Param("record") ShopCommodity record, @Param("example") ShopCommodityExample example);

    int updateByPrimaryKeySelective(ShopCommodity record);

    int updateByPrimaryKey(ShopCommodity record);
}