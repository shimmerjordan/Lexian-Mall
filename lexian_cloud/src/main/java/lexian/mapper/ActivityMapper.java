package lexian.mapper;

import lexian.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ActivityMapper {
    List<Activity> getAllActivity();

    int updateActivity(Map<String,Object> map);

    int deleteActivity(Map<String,Object> map);

    int updateActivityStatus0(Map<String,Object> map);

    int updateActivityStatus1(Map<String,Object> map);

    List<Activity> getIndexActivity();

    int getMaxActivityId();

    int insertActivity(Map<String, Object> map);

}