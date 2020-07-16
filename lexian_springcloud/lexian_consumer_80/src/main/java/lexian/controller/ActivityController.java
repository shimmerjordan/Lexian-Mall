package lexian.controller;

import com.github.pagehelper.PageInfo;
import lexian.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ActivityController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/getAllActivity")
    public PageInfo<Activity> getAllActivity(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/getAllActivity",map,PageInfo.class);
    }

    @PostMapping("/updateActivity")
    public boolean updateActivity(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/updateActivity",map,Boolean.class);
    }

    @PostMapping("/deleteActivity")
    public boolean deleteActivity(@RequestBody Map<String,Object> map) {
        return  restTemplate.postForObject(REST_PREFIX+"/deleteActivity",map,Boolean.class);
    }

    @PostMapping("/updateActivityStatus0")
    public boolean updateActivityStatus0(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/updateActivityStatus0",map,Boolean.class);
    }

    @PostMapping("/updateActivityStatus1")
    public boolean updateActivityStatus1(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/updateActivityStatus1",map, Boolean.class);
    }

    @GetMapping("/getMaxActivityId")
    public int getMaxActivityId() {
        return restTemplate.getForObject(REST_PREFIX+"/getMaxActivityId",Integer.class);
    }

    @PostMapping("/insertActivity")
    public boolean insertActivity(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/insertActivity",map,Boolean.class);
    }
}
