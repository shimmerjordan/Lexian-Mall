package lexian.service.serviceImpl;


import lexian.entity.Activity;
import lexian.mapper.ActivityMapper;
import lexian.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Service
public class ActivityServiceImpl implements ActivityService {
    private ActivityMapper activityMapper;

    /**
     * 转换获取的时间格式
     * @param UTC
     * @return
     * @throws ParseException
     */
    private String UTCToLocal(String UTC) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date temp=df.parse(UTC);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(temp);
    }
    @Autowired
    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public List<Activity> getAllActivity() {
        return activityMapper.getAllActivity();
    }

    @Override
    public boolean updateActivity(Map<String,Object> map) {
        try {
            map.put("beginTime",UTCToLocal((String)map.get("beginTime")));//从map中取出"beginTime"的值,转换号格式后写入
            map.put("endTime",UTCToLocal((String)map.get("endTime")));//与beginTime一致
            int flag = activityMapper.updateActivity(map);
            return flag > 0;
        }catch (ParseException e){
            return false;
        }
    }
//    public boolean updateActivity(Map<String,Object> map) {
//        int flag = activityMapper.updateActivity(map);
//        return flag > 0;
//    }

    @Override
    public boolean deleteActivity(Map<String,Object> map) {
        int flag = activityMapper.deleteActivity(map);
        return flag>0;
    }

    @Override
    public boolean updateActivityStatus0(Map<String,Object> map) {
        int flag = activityMapper.updateActivityStatus0(map);
        return flag>0;
    }

    @Override
    public boolean updateActivityStatus1(Map<String,Object> map) {
        int flag = activityMapper.updateActivityStatus1(map);
        return flag>0;
    }

    @Override
    public int getMaxActivityId() {
        return activityMapper.getMaxActivityId();
    }

    @Override
    public boolean insertActivity(Map<String,Object> map) {
        try {
            map.put("beginTime",UTCToLocal((String)map.get("beginTime")));
            map.put("endTime",UTCToLocal((String)map.get("endTime")));
            int flag = activityMapper.insertActivity(map);
            return flag > 0;
        }catch (ParseException e){
            return false;
        }
    }

    @Override
    public List<Activity> searchActivityByInformation(Map<String,Object> map) {
        try {
            //在传回来的值内取出"beginTime""endTime"的值进行判断
            String beginTime = (String) map.get("beginTime");
            String endTime = (String) map.get("endTime");

            //只有当开始、结束时间都输入时，才需要对时间格式转换并进行查询
            if(beginTime != null && endTime != null) {
                map.put("beginTime",UTCToLocal((String)map.get("beginTime")));
                map.put("endTime",UTCToLocal((String)map.get("endTime")));
            }
            System.out.println(map);
            return activityMapper.searchActivityByInformation(map);
        }catch (ParseException e) {
            return null;
        }
    }
}
