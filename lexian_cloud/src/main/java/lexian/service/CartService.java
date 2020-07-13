package lexian.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import lexian.entity.Cart;
import lexian.entity.CartList;
import lexian.entity.Commodity;

@Transactional
public interface CartService {
	
    List<CartList> loadCart(Map<String,Object> map);    
    
    Boolean save(Cart cart);
    
    List<Commodity> listByCartIds(List<String> cartIds);
}
