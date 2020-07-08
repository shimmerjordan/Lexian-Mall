package lexian.service.serviceImpl;

import lexian.entity.Commodity;
import lexian.mapper.CommodityMapper;

import lexian.service.UniIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UniIndexServiceImpl implements UniIndexService{
    private CommodityMapper commodityMapper;

    @Autowired
    public void setCommodityMapper(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }

    @Override
    public List<Commodity> getIndexCommodity() {
        return commodityMapper.getIndexCommodity();
    }
}
