package lexian.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import lexian.entity.Commodity;

public interface CommodityService {
<<<<<<< HEAD
    List<Commodity> getAllShopCommodity();
    boolean updateGood(Map<String,Object> map);
    boolean deleteGood(Map<String,Object> map);
	List<Commodity> listCommodityByCommodityId(String commodityId);

	boolean deleteGood(Integer id);
=======
	List<Commodity> getAllShopCommodity();

	boolean deleteGood(Map<String, Object> map);

	boolean updateGood(Map<String, Object> map);

	PageInfo<Commodity> listCommodityByCategoryId(Commodity commodity);

	boolean addGood(Map<String, Object> map);
>>>>>>> 01729adcad0723208a59d29dccc68edde3f776aa
}
