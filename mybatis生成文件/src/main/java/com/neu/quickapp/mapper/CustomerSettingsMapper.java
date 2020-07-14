package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.CustomerSettings;
import com.neu.quickapp.pojo.CustomerSettingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerSettingsMapper {
    int countByExample(CustomerSettingsExample example);

    int deleteByExample(CustomerSettingsExample example);

    int insert(CustomerSettings record);

    int insertSelective(CustomerSettings record);

    List<CustomerSettings> selectByExample(CustomerSettingsExample example);

    int updateByExampleSelective(@Param("record") CustomerSettings record, @Param("example") CustomerSettingsExample example);

    int updateByExample(@Param("record") CustomerSettings record, @Param("example") CustomerSettingsExample example);
}