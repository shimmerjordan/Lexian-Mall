package lexian.service;

import lexian.entity.Commodity;
import lexian.entity.Order;

import java.util.List;
import java.util.Map;

public interface CommodityService {
	List<Commodity> getAllShopCommodity();

	boolean updateGood(Map<String, Object> map);

	List<Commodity> listCommodityByCommodityId(String commodityId);
}
