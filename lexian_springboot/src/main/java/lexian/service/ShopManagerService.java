package lexian.service;

import lexian.entity.ShopManager;

import java.util.List;
import java.util.Map;

public interface ShopManagerService {
    List<ShopManager> searchShopManager(Map<String,Object> map);

    boolean updateShopManager(Map<String,Object> map);

    boolean deleteShopManager(Map<String,Object> map);


}
