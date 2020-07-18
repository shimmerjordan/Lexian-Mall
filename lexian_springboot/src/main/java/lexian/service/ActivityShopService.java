package lexian.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 与活动——店铺有关的service
 */
@Transactional
public interface ActivityShopService {
    boolean insertActivityShop(Map<String ,Object>map);
}
