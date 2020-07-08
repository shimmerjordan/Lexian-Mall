package lexian.service.serviceImpl;

import lexian.entity.Shop;
import lexian.mapper.ShopMapper;
import lexian.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService{
    private ShopMapper shopMapper;

    @Autowired
    public void setShopMapper(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    @Override
    public List<Shop> getAllShop() {
        return shopMapper.getAllShop();
    }

    @Override
    public int getMaxShopId() {
        return shopMapper.getMaxShopId();
    }

    @Override
    public boolean updateShop(Map<String,Object> map) {
        int flag = shopMapper.updateShop(map);
        return flag > 0;
    }
}
