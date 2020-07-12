package lexian.service;

import lexian.entity.Cart;
import lexian.entity.CartList;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface CartService {
    List<CartList> loadCart(Map<String,Object> map);
    int updateQuantity(Map<String, Object> map);
    boolean deleteCartItem(Map<String, Object> map);
    boolean save(Cart cart);
    int clearCart(List<Object> cartIdList);
}
