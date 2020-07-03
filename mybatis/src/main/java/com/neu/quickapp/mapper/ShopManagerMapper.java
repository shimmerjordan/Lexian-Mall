package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.ShopManager;
import com.neu.quickapp.pojo.ShopManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopManagerMapper {
    int countByExample(ShopManagerExample example);

    int deleteByExample(ShopManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopManager record);

    int insertSelective(ShopManager record);

    List<ShopManager> selectByExample(ShopManagerExample example);

    ShopManager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopManager record, @Param("example") ShopManagerExample example);

    int updateByExample(@Param("record") ShopManager record, @Param("example") ShopManagerExample example);

    int updateByPrimaryKeySelective(ShopManager record);

    int updateByPrimaryKey(ShopManager record);
}