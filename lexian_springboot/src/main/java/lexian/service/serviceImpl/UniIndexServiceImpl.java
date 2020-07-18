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

/**
 * UniApp首页相关的Service接口实现
 */

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

    /**
     * 获取UniApp首页所有商品数据的方法重写
     * @return
     */
    @Override
    public List<Commodity> getIndexCommodity() {
        return commodityMapper.getIndexCommodity();
    }
    /**
     * 获取UniApp首页所有活动数据的方法重写
     * @return
     */
    @Override
    public List<Activity> getIndexActivity() {
        return activityMapper.getIndexActivity();
    }
    /**
     * 根据商品名称模糊搜索获取商品数据的方法重写
     * @param name
     * @return
     */
    @Override
    public List<Commodity> getIndexSearchCommodity(String name){
        return commodityMapper.getIndexSearchCommodity(name);
    }
    /**
     * 根据首页活动ID获取活动商品数据的方法重写
     * @param aID
     * @return
     */
    @Override
    public List<Commodity> getSalesItem(String aID){
        return commodityMapper.getSalesItem(aID);
    }
}

