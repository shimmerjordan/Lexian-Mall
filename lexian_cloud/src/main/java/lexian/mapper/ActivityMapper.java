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

<<<<<<< HEAD
    List<Activity> getIndexActivity();
=======
    int getMaxActivityId();

    int insertActivity(Map<String, Object> map);
>>>>>>> 0357ca5fd2db2438f261b5ceb2e151c5d3a74deb
}