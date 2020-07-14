package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.Index;
import com.neu.quickapp.pojo.IndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexMapper {
    int countByExample(IndexExample example);

    int deleteByExample(IndexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Index record);

    int insertSelective(Index record);

    List<Index> selectByExample(IndexExample example);

    Index selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Index record, @Param("example") IndexExample example);

    int updateByExample(@Param("record") Index record, @Param("example") IndexExample example);

    int updateByPrimaryKeySelective(Index record);

    int updateByPrimaryKey(Index record);
}