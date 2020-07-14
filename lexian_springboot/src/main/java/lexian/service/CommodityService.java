package lexian.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import lexian.entity.Category;
import lexian.entity.Commodity;

public interface CommodityService {
    List<Commodity> getAllShopCommodity();

	boolean updateGood(Map<String, Object> map);

	List<Commodity> listCommodityByCommodityId(String commodityId);
	boolean deleteGood(Integer id);
	boolean deleteGood(Map<String, Object> map);
	PageInfo<Commodity> listCommodityByCategoryId(Commodity commodity);
	boolean addGood(Map<String, Object> map);
	
	Commodity getCommodity(String commodityId);

	List<Category> getAllCategory();
<<<<<<< HEAD:lexian_cloud/src/main/java/lexian/service/CommodityService.java
=======

	List<Commodity> getAllShopCommodityByName(String name);
	
>>>>>>> 1e1173b9e37dd5810d32c08753b04cdbb32acd72:lexian_springboot/src/main/java/lexian/service/CommodityService.java
}
