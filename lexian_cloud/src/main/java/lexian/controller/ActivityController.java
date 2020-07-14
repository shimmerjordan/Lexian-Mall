package lexian.controller;

import lexian.entity.Activity;
import lexian.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/updateActivity")
    public boolean updateActivity(@RequestBody Map<String,Object> map){

        System.out.println(map);
        return activityService.updateActivity(map);
    }

    @PostMapping("/deleteActivity")
    public boolean deleteActivity(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return activityService.deleteActivity(map);
    }

    @PostMapping("/updateActivityStatus0")
    public boolean updateActivityStatus0(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return activityService.updateActivityStatus0(map);
    }

    @PostMapping("/updateActivityStatus1")
    public boolean updateActivityStatus1(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return activityService.updateActivityStatus1(map);
    }


    @GetMapping("/getMaxActivityId")
    public int getMaxActivityId() {
        return activityService.getMaxActivityId();
    }

    @PostMapping("/insertActivity")
    public boolean insertActivity(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return activityService.insertActivity(map);
    }
}
