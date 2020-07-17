package lexian.service;

import lexian.entity.Shop;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 有关店铺的service
 */
@Transactional
public interface ShopService {
    List<Shop> getAllShop();

    int getMaxShopId();

    boolean updateShop(Map<String,Object> map);

    boolean deleteShop(Map<String,Object> map);

    List<Shop> searchShopByInformation(Map<String,Object> map);

    boolean insertShop(Map<String, Object> map);

    boolean updateShopStatus0(List<Object> list);

    boolean updateShopStatus1(List<Object> list);

    boolean updateShopStatus2(List<Object> list);
}
