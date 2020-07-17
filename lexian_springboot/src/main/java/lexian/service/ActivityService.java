package lexian.service;

import lexian.entity.Activity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 与店铺有关的service方法
 */
@Transactional
public interface ActivityService {
    List<Activity> getAllActivity();

    boolean updateActivity(Map<String,Object> map);

    boolean deleteActivity(Map<String,Object> map);

    boolean updateActivityStatus0(Map<String,Object> map);

    boolean updateActivityStatus1(Map<String,Object> map);

    int getMaxActivityId();

    boolean insertActivity(Map<String, Object> map);

    List<Activity> searchActivityByInformation(Map<String,Object>map);

}
