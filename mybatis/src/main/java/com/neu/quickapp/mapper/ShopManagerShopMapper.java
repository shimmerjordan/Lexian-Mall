package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.ShopManagerShop;
import com.neu.quickapp.pojo.ShopManagerShopExample;
import com.neu.quickapp.pojo.ShopManagerShopKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopManagerShopMapper {
    int countByExample(ShopManagerShopExample example);

    int deleteByExample(ShopManagerShopExample example);

    int deleteByPrimaryKey(ShopManagerShopKey key);

    int insert(ShopManagerShop record);

    int insertSelective(ShopManagerShop record);

    List<ShopManagerShop> selectByExample(ShopManagerShopExample example);

    ShopManagerShop selectByPrimaryKey(ShopManagerShopKey key);

    int updateByExampleSelective(@Param("record") ShopManagerShop record, @Param("example") ShopManagerShopExample example);

    int updateByExample(@Param("record") ShopManagerShop record, @Param("example") ShopManagerShopExample example);

    int updateByPrimaryKeySelective(ShopManagerShop record);

    int updateByPrimaryKey(ShopManagerShop record);
}