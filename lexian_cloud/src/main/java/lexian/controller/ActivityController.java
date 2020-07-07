package lexian.controller;

import lexian.entity.Activity;
import lexian.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {
    private ActivityService activityService;

    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/getAllActivity")
    public List<Activity> getAllActivity() {
        return activityService.getAllActivity();
    }

}
