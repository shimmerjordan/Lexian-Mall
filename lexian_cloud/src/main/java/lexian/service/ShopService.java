package lexian.service;

import lexian.entity.Shop;

import java.util.List;
import java.util.Map;

public interface ShopService {
    List<Shop> getAllShop();

    int getMaxShopId();

    boolean updateShop(Map<String,Object> map);

    boolean deleteShop(Map<String,Object> map);

    List<Shop> searchShop(Map<String,Object> map);

    boolean insertShop(Map<String, Object> map);
}
