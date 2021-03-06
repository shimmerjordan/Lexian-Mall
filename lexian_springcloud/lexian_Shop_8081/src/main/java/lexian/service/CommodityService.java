package lexian.service;

import com.github.pagehelper.PageInfo;
import lexian.entity.Category;
import lexian.entity.Commodity;

import java.util.List;
import java.util.Map;

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

	List<Commodity> getAllShopCommodityByName(String name);

}
