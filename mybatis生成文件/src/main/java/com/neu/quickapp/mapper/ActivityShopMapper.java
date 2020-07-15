package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.ActivityShop;
import com.neu.quickapp.pojo.ActivityShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityShopMapper {
    int countByExample(ActivityShopExample example);

    int deleteByExample(ActivityShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityShop record);

    int insertSelective(ActivityShop record);

    List<ActivityShop> selectByExample(ActivityShopExample example);

    ActivityShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityShop record, @Param("example") ActivityShopExample example);

    int updateByExample(@Param("record") ActivityShop record, @Param("example") ActivityShopExample example);

    int updateByPrimaryKeySelective(ActivityShop record);

    int updateByPrimaryKey(ActivityShop record);
}