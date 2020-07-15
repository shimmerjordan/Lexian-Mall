package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.Settings;
import com.neu.quickapp.pojo.SettingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettingsMapper {
    int countByExample(SettingsExample example);

    int deleteByExample(SettingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Settings record);

    int insertSelective(Settings record);

    List<Settings> selectByExample(SettingsExample example);

    Settings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Settings record, @Param("example") SettingsExample example);

    int updateByExample(@Param("record") Settings record, @Param("example") SettingsExample example);

    int updateByPrimaryKeySelective(Settings record);

    int updateByPrimaryKey(Settings record);
}