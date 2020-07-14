package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.BrowsingRecord;
import com.neu.quickapp.pojo.BrowsingRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrowsingRecordMapper {
    int countByExample(BrowsingRecordExample example);

    int deleteByExample(BrowsingRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BrowsingRecord record);

    int insertSelective(BrowsingRecord record);

    List<BrowsingRecord> selectByExample(BrowsingRecordExample example);

    BrowsingRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BrowsingRecord record, @Param("example") BrowsingRecordExample example);

    int updateByExample(@Param("record") BrowsingRecord record, @Param("example") BrowsingRecordExample example);

    int updateByPrimaryKeySelective(BrowsingRecord record);

    int updateByPrimaryKey(BrowsingRecord record);
}