package lexian.service.serviceImpl;

import lexian.entity.Cart;
import lexian.entity.CartList;
import lexian.entity.Commodity;
import lexian.mapper.CartMapper;
import lexian.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Autowired
	public void setCartMapper(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}

	@Override
	public List<CartList> loadCart(Map<String, Object> map) {
		System.out.println(map);
		return cartMapper.loadCart(map);
	}

	public Boolean save(Cart cart) {
		Cart scart = cartMapper.selectCart(cart);
		if (null != scart) {
			scart.setCommodityQuantity(scart.getCommodityQuantity() + cart.getCommodityQuantity());
			return cartMapper.update(scart) > 0;
		}
		return cartMapper.insert(cart) > 0;
	}

	@Override
	public List<Commodity> listByCartIds(List<String> cartIds) {
		
		return cartMapper.selectCommodityByCartIds(cartIds);
	}
}
