package lexian.service.serviceImpl;


import lexian.entity.Activity;
import lexian.mapper.ActivityMapper;
import lexian.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    private ActivityMapper activityMapper;

    @Autowired
    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public List<Activity> getAllActivity() {
        return activityMapper.getAllActivity();
    }
}
