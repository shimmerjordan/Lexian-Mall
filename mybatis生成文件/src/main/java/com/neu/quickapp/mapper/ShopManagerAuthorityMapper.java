package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.ShopManagerAuthority;
import com.neu.quickapp.pojo.ShopManagerAuthorityExample;
import com.neu.quickapp.pojo.ShopManagerAuthorityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopManagerAuthorityMapper {
    int countByExample(ShopManagerAuthorityExample example);

    int deleteByExample(ShopManagerAuthorityExample example);

    int deleteByPrimaryKey(ShopManagerAuthorityKey key);

    int insert(ShopManagerAuthority record);

    int insertSelective(ShopManagerAuthority record);

    List<ShopManagerAuthority> selectByExample(ShopManagerAuthorityExample example);

    ShopManagerAuthority selectByPrimaryKey(ShopManagerAuthorityKey key);

    int updateByExampleSelective(@Param("record") ShopManagerAuthority record, @Param("example") ShopManagerAuthorityExample example);

    int updateByExample(@Param("record") ShopManagerAuthority record, @Param("example") ShopManagerAuthorityExample example);

    int updateByPrimaryKeySelective(ShopManagerAuthority record);

    int updateByPrimaryKey(ShopManagerAuthority record);
}