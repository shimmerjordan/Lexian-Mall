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

<<<<<<< HEAD
=======
    int getMaxActivityId();

    boolean insertActivity(Map<String, Object> map);
>>>>>>> 0357ca5fd2db2438f261b5ceb2e151c5d3a74deb
}
