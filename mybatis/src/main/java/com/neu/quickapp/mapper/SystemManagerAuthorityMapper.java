package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.SystemManagerAuthority;
import com.neu.quickapp.pojo.SystemManagerAuthorityExample;
import com.neu.quickapp.pojo.SystemManagerAuthorityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemManagerAuthorityMapper {
    int countByExample(SystemManagerAuthorityExample example);

    int deleteByExample(SystemManagerAuthorityExample example);

    int deleteByPrimaryKey(SystemManagerAuthorityKey key);

    int insert(SystemManagerAuthority record);

    int insertSelective(SystemManagerAuthority record);

    List<SystemManagerAuthority> selectByExample(SystemManagerAuthorityExample example);

    SystemManagerAuthority selectByPrimaryKey(SystemManagerAuthorityKey key);

    int updateByExampleSelective(@Param("record") SystemManagerAuthority record, @Param("example") SystemManagerAuthorityExample example);

    int updateByExample(@Param("record") SystemManagerAuthority record, @Param("example") SystemManagerAuthorityExample example);

    int updateByPrimaryKeySelective(SystemManagerAuthority record);

    int updateByPrimaryKey(SystemManagerAuthority record);
}