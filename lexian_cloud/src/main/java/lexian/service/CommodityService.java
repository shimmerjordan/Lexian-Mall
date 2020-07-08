package lexian.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import lexian.entity.Commodity;

public interface CommodityService {
	List<Commodity> getAllShopCommodity();

	boolean deleteGood(Map<String, Object> map);

	boolean updateGood(Map<String, Object> map);

	PageInfo<Commodity> listCommodityByCategoryId(Commodity commodity);

	boolean addGood(Map<String, Object> map);
	
	Commodity getCommodity(String commodityId);
	
}
