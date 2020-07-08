package lexian.service;

import lexian.entity.Commodity;
import lexian.entity.Order;

import java.util.List;
import java.util.Map;

public interface CommodityService {
<<<<<<< HEAD
	List<Commodity> getAllShopCommodity();

	boolean updateGood(Map<String, Object> map);

	List<Commodity> listCommodityByCommodityId(String commodityId);
=======
    List<Commodity> getAllShopCommodity();
    boolean updateGood(Map<String,Object> map);
    boolean deleteGood(Integer id);
>>>>>>> 122c06bec5b91ce7f9e6cd31ce6e172106c86c08
}
