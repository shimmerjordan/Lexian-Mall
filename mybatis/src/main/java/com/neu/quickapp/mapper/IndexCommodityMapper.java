package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.IndexCommodity;
import com.neu.quickapp.pojo.IndexCommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexCommodityMapper {
    int countByExample(IndexCommodityExample example);

    int deleteByExample(IndexCommodityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndexCommodity record);

    int insertSelective(IndexCommodity record);

    List<IndexCommodity> selectByExample(IndexCommodityExample example);

    IndexCommodity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexCommodity record, @Param("example") IndexCommodityExample example);

    int updateByExample(@Param("record") IndexCommodity record, @Param("example") IndexCommodityExample example);

    int updateByPrimaryKeySelective(IndexCommodity record);

    int updateByPrimaryKey(IndexCommodity record);
}