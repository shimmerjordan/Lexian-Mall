package lexian.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import lexian.entity.Category;
import lexian.entity.Commodity;

/**
 * 商品相关的Service
 */
public interface CommodityService {
	/**
	 * 获取所有的商品列表
	 * @return
	 */
    List<Commodity> getAllShopCommodity();

	/**
	 * 更新商品的信息
	 * @param map
	 * @return
	 */
	boolean updateGood(Map<String, Object> map);

	/**
	 * 根据商品Id获取商品
	 * @param commodityId
	 * @return
	 */
	List<Commodity> listCommodityByCommodityId(String commodityId);

	/**
	 * 根据id删除商品
	 * @param id
	 * @return
	 */
	boolean deleteGood(Integer id);

	/**
	 * 删除商品
	 * @param map
	 * @return
	 */
	boolean deleteGood(Map<String, Object> map);

	/**
	 * 根据商品类别查询商品
	 * @param commodity
	 * @return
	 */
	PageInfo<Commodity> listCommodityByCategoryId(Commodity commodity);

	/**
	 * 添加商品
	 * @param map
	 * @return
	 */
	boolean addGood(Map<String, Object> map);

	/**
	 * 根据商品id查询商品
	 * @param commodityId
	 * @return
	 */
	Commodity getCommodity(String commodityId);

	/**
	 * 获取所有的商品种类
	 * @return
	 */
	List<Category> getAllCategory();

	/**
	 * 根据名字进行商品查询
	 * @param name
	 * @return
	 */
	List<Commodity> getAllShopCommodityByName(String name);

}
