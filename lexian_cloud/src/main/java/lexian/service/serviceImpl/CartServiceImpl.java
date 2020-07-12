package lexian.service.serviceImpl;


import lexian.entity.CartList;
import lexian.mapper.CartMapper;
import lexian.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    private CartMapper cartMapper;

    @Autowired
    public void setCartMapper(CartMapper cartMapper){
        this.cartMapper = cartMapper;
    }

    @Override
    public List<CartList> loadCart(Map<String, Object> map) {
        System.out.println(map);
        return cartMapper.loadCart(map);
    }

    @Override
    public int updateQuantity(Map<String, Object> map) {
        return cartMapper.updateQuantity(map);
    }

    @Override
    public boolean deleteCartItem(Map<String, Object> map) {
        return cartMapper.deleteCartItem(map);
    }
}
