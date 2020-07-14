package lexian.mapper;

import lexian.entity.SpecsCommodity;

public interface SpecsCommodityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpecsCommodity record);

    int insertSelective(SpecsCommodity record);

    SpecsCommodity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpecsCommodity record);

    int updateByPrimaryKey(SpecsCommodity record);
}