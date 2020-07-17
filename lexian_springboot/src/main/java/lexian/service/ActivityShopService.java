package lexian.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
public interface ActivityShopService {
    boolean insertActivityShop(Map<String ,Object>map);
}
