package com.neu.quickapp.mapper;

import com.neu.quickapp.pojo.Jiufen;
import com.neu.quickapp.pojo.JiufenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JiufenMapper {
    int countByExample(JiufenExample example);

    int deleteByExample(JiufenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jiufen record);

    int insertSelective(Jiufen record);

    List<Jiufen> selectByExample(JiufenExample example);

    Jiufen selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jiufen record, @Param("example") JiufenExample example);

    int updateByExample(@Param("record") Jiufen record, @Param("example") JiufenExample example);

    int updateByPrimaryKeySelective(Jiufen record);

    int updateByPrimaryKey(Jiufen record);
}