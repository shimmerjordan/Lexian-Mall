package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.ActivityCommodity;
import com.neu.quickapp.pojo.ActivityCommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityCommodityMapper {
    int countByExample(ActivityCommodityExample example);

    int deleteByExample(ActivityCommodityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityCommodity record);

    int insertSelective(ActivityCommodity record);

    List<ActivityCommodity> selectByExample(ActivityCommodityExample example);

    ActivityCommodity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityCommodity record, @Param("example") ActivityCommodityExample example);

    int updateByExample(@Param("record") ActivityCommodity record, @Param("example") ActivityCommodityExample example);

    int updateByPrimaryKeySelective(ActivityCommodity record);

    int updateByPrimaryKey(ActivityCommodity record);
}