package lexian.service;

import lexian.entity.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    List<Activity> getAllActivity();

    boolean updateActivity(Map<String,Object> map);

    boolean deleteActivity(Map<String,Object> map);

    boolean updateActivityStatus0(Map<String,Object> map);

    boolean updateActivityStatus1(Map<String,Object> map);

    int getMaxActivityId();

    boolean insertActivity(Map<String, Object> map);
<<<<<<< HEAD:lexian_cloud/src/main/java/lexian/service/ActivityService.java
=======

    List<Activity> searchActivityByInformation(Map<String,Object>map);

>>>>>>> 1e1173b9e37dd5810d32c08753b04cdbb32acd72:lexian_springboot/src/main/java/lexian/service/ActivityService.java
}
