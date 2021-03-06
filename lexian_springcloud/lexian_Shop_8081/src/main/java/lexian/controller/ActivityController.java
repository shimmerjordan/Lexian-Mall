package lexian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.Activity;
import lexian.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ActivityController {
    private ActivityService activityService;

    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

//    @GetMapping("/getAllActivity")
//    public List<Activity> getAllActivity() {
//
//        return activityService.getAllActivity();
//    }

    @PostMapping("/getAllActivity")
    public PageInfo<Activity> getAllActivity(@RequestBody Map<String,Object> map) {
        int pageNo = Integer.parseInt(String.valueOf(map.get("page")));
        int limit = Integer.parseInt(String.valueOf(map.get("limit")));
        PageHelper.startPage(pageNo,limit);
        List<Activity> resultList;
        String name=(String)map.get("name");
        String id = (String)map.get("id");
        String beginTime = (String) map.get("beginTime");
        String endTime = (String) map.get("endTime");
        String status = (String)map.get("status");
        if(name!=null || id != null || status != null
                || (beginTime != null && endTime !=null)){
            String changeName="%"+name+"%";
            map.put("name",changeName);
//            map.put("status",changeStatus);
            System.out.println(map);
            resultList = activityService.searchActivityByInformation(map);
        }
        else {
            resultList = activityService.getAllActivity();
        }
        PageInfo<Activity> result = new PageInfo<Activity>(resultList);
        System.out.print(result);
        return result;
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
