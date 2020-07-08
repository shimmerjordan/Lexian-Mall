package lexian.service;

import lexian.entity.Commodity;
import lexian.entity.Order;

import java.util.List;
import java.util.Map;


public interface CommodityService {
    List<Commodity> getAllShopCommodity();
    boolean updateGood(Map<String,Object> map);
    boolean deleteGood(Map<String,Object> map);
}
