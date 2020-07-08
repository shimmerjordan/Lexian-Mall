package lexian.service.serviceImpl;

import lexian.entity.Commodity;
import lexian.mapper.CommodityMapper;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public List<Commodity> listCommodityByCommodityId(String commodityId) {

<<<<<<< HEAD
		return commodityMapper.selectCommodityByCommodityId(commodityId);
	}
=======
    @Override
    public boolean updateGood(Map<String,Object> map) {
        int flag=commodityMapper.updateGood(map);
        return  flag>0;
    }

    @Override
    public boolean deleteGood(Integer id) {
        int flag=commodityMapper.deleteGood(id);
        return flag>0;
    }
>>>>>>> 122c06bec5b91ce7f9e6cd31ce6e172106c86c08
}
