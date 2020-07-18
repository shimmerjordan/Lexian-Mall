package lexian.service;

import lexian.entity.Activity;
import lexian.entity.Commodity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * UniApp用户中心相关的Service
 */
@Transactional
public interface UniIndexService {
    /**
     * 获取UniApp首页所有商品数据
     * @return
     */
    List<Commodity> getIndexCommodity();
    /**
     * 获取UniApp首页所有活动数据
     * @return
     */
    List<Activity> getIndexActivity();
    /**
     * 根据商品名称模糊搜索获取商品数据
     * @param name
     * @return
     */
    List<Commodity> getIndexSearchCommodity(String name);

    /**
     * 根据首页活动ID获取活动商品数据
     * @param aID
     * @return
     */
    List<Commodity> getSalesItem(String aID);
}
