package lexian.service;

import lexian.entity.ShopManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface ShopManagerService {
    List<ShopManager> searchShopManager(Map<String,Object> map);

    boolean updateShopManager(Map<String,Object> map);

    boolean deleteShopManager(Map<String,Object> map);


}
