package lexian.mapper;


import lexian.entity.Category;
import lexian.entity.Commodity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommodityMapper {
	/**
	 * 获取所有的商品
	 * @return
	 */
	List<Commodity> getAllShopCommodity();

	/**
	 * 更新商品信息
	 * @param map
	 * @return
	 */
	int updateGood(Map<String, Object> map);

	/**
	 * 删除商品
	 * @param map
	 * @return
	 */
	int deleteGood(Map<String, Object> map);

	/**
	 * 根据商品id找商品
	 * @param commodityId
	 * @return
	 */
	List<Commodity> selectCommodityByCommodityId(String commodityId);

	/**
	 * 获取商品id
	 * @return
	 */
	List<Commodity> getIndexCommodity();

	/**
	 * 根据id删除商品
	 * @param id
	 * @return
	 */
	int deleteGood(Integer id);

	/**
	 * 根据种类查询商品
	 * @param commodity
	 * @return
	 */
	List<Commodity> selectCommodityByCategoryId(Commodity commodity);

	/**
	 * 添加新的商品
	 * @param map
	 * @return
	 */
	int addGood(Map<String, Object> map);

	/**
	 * 根据商品ID选中商品
	 * @param commodityId
	 * @return
	 */
	Commodity selectCommodityById(String commodityId);

	/**
	 * 获取所有种类
	 * @return
	 */
	List<Category> getAllCategory();

	/**
	 * 根据名字检索商品
	 * @param name
	 * @return
	 */
	List<Commodity> getIndexSearchCommodity(String name);

	/**
	 * 根据名字找到所有商品
	 * @param name
	 * @return
	 */
	List<Commodity> getAllShopCommodityByName(String name);

	/**
	 * 根据顾客id找到所有顾客的收藏商品
	 * @param userID
	 * @return
	 */
	List<Commodity> getFavorites(String userID);

	/**
	 * 获取在售商品
	 * @param aID
	 * @return
	 */
	List<Commodity> getSalesItem(String aID);

	/**
	 * 根据种类查询所有商品
	 * @param map
	 * @return
	 */
	List<Commodity> getAllCommodityByCategory(Map<String, Object> map);
}

