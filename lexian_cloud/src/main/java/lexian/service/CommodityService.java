package lexian.service;

import java.util.List;
import java.util.Map;

import lexian.entity.Commodity;

public interface CommodityService {
    List<Commodity> getAllShopCommodity();
    boolean updateGood(Map<String,Object> map);
    boolean deleteGood(Map<String,Object> map);

	List<Commodity> listCommodityByCommodityId(String commodityId);

	boolean deleteGood(Integer id);
}
