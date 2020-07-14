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

<<<<<<< HEAD:lexian_cloud/src/main/java/lexian/mapper/ActivityMapper.java

=======
>>>>>>> 1e1173b9e37dd5810d32c08753b04cdbb32acd72:lexian_springboot/src/main/java/lexian/mapper/ActivityMapper.java
    List<Activity> getIndexActivity();

    int getMaxActivityId();

    int insertActivity(Map<String, Object> map);

<<<<<<< HEAD:lexian_cloud/src/main/java/lexian/mapper/ActivityMapper.java
=======
    List<Activity> searchActivityByInformation(Map<String,Object>map);

>>>>>>> 1e1173b9e37dd5810d32c08753b04cdbb32acd72:lexian_springboot/src/main/java/lexian/mapper/ActivityMapper.java
}