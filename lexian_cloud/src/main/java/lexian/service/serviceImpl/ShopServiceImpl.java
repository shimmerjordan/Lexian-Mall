package lexian.service.serviceImpl;

import lexian.entity.Shop;
import lexian.mapper.ShopMapper;
import lexian.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  java.util.List;

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

    public int getMaxShopId() {
        return shopMapper.getMaxShopId();
    }

//    public List<Shop> updateShop(Shop record) {
//        return shopMapper. updateShop(record);
//    }
}
