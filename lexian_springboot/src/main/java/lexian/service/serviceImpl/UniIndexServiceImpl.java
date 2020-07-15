package lexian.service.serviceImpl;

import lexian.entity.Activity;
import lexian.entity.Commodity;
import lexian.mapper.ActivityMapper;
import lexian.mapper.CommodityMapper;

import lexian.service.UniIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class UniIndexServiceImpl implements UniIndexService{
    private CommodityMapper commodityMapper;
    private ActivityMapper activityMapper;

    @Autowired
    public void setCommodityMapper(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }

    @Autowired
    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public List<Commodity> getIndexCommodity() {
        return commodityMapper.getIndexCommodity();
    }

    @Override
    public List<Activity> getIndexActivity() {
        return activityMapper.getIndexActivity();
    }

    @Override
    public List<Commodity> getIndexSearchCommodity(String name){
        return commodityMapper.getIndexSearchCommodity(name);
    }
}

