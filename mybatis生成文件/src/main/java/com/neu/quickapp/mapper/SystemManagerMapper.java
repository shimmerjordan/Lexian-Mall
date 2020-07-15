package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.SystemManager;
import com.neu.quickapp.pojo.SystemManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemManagerMapper {
    int countByExample(SystemManagerExample example);

    int deleteByExample(SystemManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemManager record);

    int insertSelective(SystemManager record);

    List<SystemManager> selectByExample(SystemManagerExample example);

    SystemManager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemManager record, @Param("example") SystemManagerExample example);

    int updateByExample(@Param("record") SystemManager record, @Param("example") SystemManagerExample example);

    int updateByPrimaryKeySelective(SystemManager record);

    int updateByPrimaryKey(SystemManager record);
}