package lexian.service.serviceImpl;


import lexian.entity.Commodity;
import lexian.mapper.CommodityMapper;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public void updateGood(Commodity updateGood) {
        commodityMapper.updateGood(updateGood);
    }
}
