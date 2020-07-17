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

    /**
     * 获取全部店铺活动信息
     * @param map
     * @return
     */
    @PostMapping("/getAllActivity")
    public PageInfo<Activity> getAllActivity(@RequestBody Map<String,Object> map) {
        //分页
        //page得到页数，limit为一页有多少元素
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        PageHelper.startPage(pageNo,limit);
        List<Activity> resultList;

        //从传回来的值中获取name,id,beginTime,endTime值后续进行判断
        String name=(String)map.get("name");
        String id = (String)map.get("id");
        String beginTime = (String) map.get("beginTime");
        String endTime = (String) map.get("endTime");
        String status = (String)map.get("status");

        //判断是否需要根据前端传回的值进行查询操作，如果任一项不为空则执行查询操作。如果为空，获取全部活动信息
        if(name!=null || id != null || status != null
                || (beginTime != null && endTime !=null)){
            String changeName="%"+name+"%";
            map.put("name",changeName);//模糊查询操作，将前端输入的名字赋值为%xx%，方便SQL操作
            System.out.println(map);
            resultList = activityService.searchActivityByInformation(map);
        }
        else { //条件为空则获取全部信息
            resultList = activityService.getAllActivity();
        }
        PageInfo<Activity> result = new PageInfo<>(resultList);
        System.out.print(result);
        return result;
    }

    /**
     * 更新店铺活动信息
     * @param map
     * @return
     */
    @PostMapping("/updateActivity")
    public boolean updateActivity(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return activityService.updateActivity(map);
    }

    /**
     * 删除店铺活动信息（将活动的删除标记更新）
     * @param map
     * @return
     */
    @PostMapping("/deleteActivity")
    public boolean deleteActivity(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return activityService.deleteActivity(map);
    }

    /**
     * 更新活动状态为已发布
     * @param map
     * @return
     */
    @PostMapping("/updateActivityStatus0")
    public boolean updateActivityStatus0(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return activityService.updateActivityStatus0(map);
    }

    /**
     * 更新活动状态为是草稿
     * @param map
     * @return
     */
    @PostMapping("/updateActivityStatus1")
    public boolean updateActivityStatus1(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return activityService.updateActivityStatus1(map);
    }

    /**
     * 获取此时活动的最大id
     * @return
     */
    @GetMapping("/getMaxActivityId")
    public int getMaxActivityId() {
        return activityService.getMaxActivityId();
    }

    /**
     * 插入活动信息
     * @param map
     * @return
     */
    @PostMapping("/insertActivity")
    public boolean insertActivity(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return activityService.insertActivity(map);
    }
}
