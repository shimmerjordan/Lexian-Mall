package lexian.service.serviceImpl;

import lexian.mapper.ActivityShopMapper;
import lexian.service.ActivityShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ActivityShopServiceImpl implements ActivityShopService {
    private ActivityShopMapper activityShopMapper;

    @Autowired
    public void setActivityShopMapper(ActivityShopMapper activityShopMapper){
        this.activityShopMapper = activityShopMapper;
    }
    @Override
    public boolean insertActivityShop(Map<String,Object>map) {
        int flag = activityShopMapper.insertActivityShop(map);
        return flag > 0;
    }

}
