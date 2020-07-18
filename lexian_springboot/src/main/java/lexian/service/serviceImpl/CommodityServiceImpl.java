package lexian.service.serviceImpl;

import lexian.entity.Category;
import lexian.entity.Commodity;
import lexian.mapper.CommodityMapper;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 商品相关的Service接口实现
 */

@Service
public class CommodityServiceImpl implements CommodityService {
	private CommodityMapper commodityMapper;

	@Autowired
	public void setCommodityMapper(CommodityMapper commodityMapper) {
		this.commodityMapper = commodityMapper;
	}

	/**
	 * 获取所有商品信息列表方法重写
	 * @return
	 */
	@Override
	public List<Commodity> getAllShopCommodity() {
		return commodityMapper.getAllShopCommodity();
	}

	/**
	 * 更新商品方法重写
	 * @param map
	 * @return
	 */
	@Override
	public boolean updateGood(Map<String, Object> map) {
		int flag = commodityMapper.updateGood(map);
		return flag > 0;
	}

	/**
	 * 根据类别ID获取商品方法重写
	 * @param commodity
	 * @return
	 */
	@Override
	public PageInfo<Commodity> listCommodityByCategoryId(Commodity commodity) {
		int pageNo = commodity.getPageNo();
		int pageSize = commodity.getPageSize();
		PageHelper.startPage(pageNo, pageSize);
		PageInfo<Commodity> pageInfo = new PageInfo<>(commodityMapper.selectCommodityByCategoryId(commodity));
		return pageInfo;
	}

	/**
	 * 删除商品方法重写
	 * @param map
	 * @return
	 */
	@Override
	public boolean deleteGood(Map<String, Object> map) {
		int flag = commodityMapper.deleteGood(map);
		return flag > 0;
	}
	@Override
	public List<Commodity> listCommodityByCommodityId(String commodityId) {
		return null;
	}

	@Override
	public boolean deleteGood(Integer id) {
		return false;
	}

	/**
	 * 添加商品方法重写
	 * @param map
	 * @return
	 */
	@Override
	public boolean addGood(Map<String, Object> map) {
		int flag = commodityMapper.addGood(map);
		return flag > 0;
	}

	/**
	 * 商品id查商品方法重写
	 * @param commodityId
	 * @return
	 */
	@Override
	public Commodity getCommodity(String commodityId) {
		Commodity commodity = commodityMapper.selectCommodityById(commodityId);		
		return commodity;
	}

	/**
	 * 获取所有商品类别方法重写
	 * @return
	 */
	@Override
	public List<Category> getAllCategory() {
		return commodityMapper.getAllCategory();
	}

	/**
	 * 商品名字查商品方法重写
	 * @param name
	 * @return
	 */
	@Override
	public List<Commodity> getAllShopCommodityByName(String name) {
		return commodityMapper.getAllShopCommodityByName(name);
	}
}
