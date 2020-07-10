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
            map.put("beginTime",UTCToLocal((String)map.get("beginTime")));
            map.put("endTime",UTCToLocal((String)map.get("endTime")));
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

<<<<<<< HEAD

=======
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
>>>>>>> 0357ca5fd2db2438f261b5ceb2e151c5d3a74deb
}
