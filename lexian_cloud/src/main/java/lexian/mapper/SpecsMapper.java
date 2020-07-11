package lexian.mapper;

import lexian.entity.Specs;

public interface SpecsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Specs record);

    int insertSelective(Specs record);

    Specs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specs record);

    int updateByPrimaryKey(Specs record);
}

