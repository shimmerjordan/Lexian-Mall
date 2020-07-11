package lexian.service;

import lexian.entity.CartList;
import lexian.entity.Commodity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface CartService {
    List<CartList> loadCart(Map<String,Object> map);
}
