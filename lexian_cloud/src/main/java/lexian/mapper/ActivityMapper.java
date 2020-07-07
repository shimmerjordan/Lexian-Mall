package lexian.mapper;

import lexian.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    List<Activity> getAllActivity();
}