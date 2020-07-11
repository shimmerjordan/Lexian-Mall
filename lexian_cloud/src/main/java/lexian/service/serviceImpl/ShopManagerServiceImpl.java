package lexian.service.serviceImpl;

import lexian.entity.ShopManager;
import lexian.mapper.ShopManagerMapper;
import lexian.service.ShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopManagerServiceImpl implements ShopManagerService{
    private ShopManagerMapper shopManagerMapper;

    @Autowired
    public void setShopManagerMapper(ShopManagerMapper shopManagerMapper){
        this.shopManagerMapper = shopManagerMapper;
    }

    @Override
    public List<ShopManager> searchShopManager(Map<String,Object> map){
        return shopManagerMapper.searchShopManager(map);
    }
}
