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
}
