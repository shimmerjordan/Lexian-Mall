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

@Service
public class CommodityServiceImpl implements CommodityService {
	private CommodityMapper commodityMapper;

	@Autowired
	public void setCommodityMapper(CommodityMapper commodityMapper) {
		this.commodityMapper = commodityMapper;
	}

	@Override
	public List<Commodity> getAllShopCommodity() {
		return commodityMapper.getAllShopCommodity();
	}

	@Override
	public boolean updateGood(Map<String, Object> map) {
		int flag = commodityMapper.updateGood(map);
		return flag > 0;
	}

	@Override
	public PageInfo<Commodity> listCommodityByCategoryId(Commodity commodity) {
		int pageNo = commodity.getPageNo();
		int pageSize = commodity.getPageSize();
		PageHelper.startPage(pageNo, pageSize);
		PageInfo<Commodity> pageInfo = new PageInfo<>(commodityMapper.selectCommodityByCategoryId(commodity));
		return pageInfo;
	}

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

	@Override
	public boolean addGood(Map<String, Object> map) {
		int flag = commodityMapper.addGood(map);
		return flag > 0;
	}

	@Override
	public Commodity getCommodity(String commodityId) {
		Commodity commodity = commodityMapper.selectCommodityById(commodityId);		
		return commodity;
	}

	@Override
	public List<Category> getAllCategory() {
		return commodityMapper.getAllCategory();
	}
}
