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
	private CartMapper cartMapper;

	@Autowired
	public void setCartMapper(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}

	/**
	 * @note 加载购物车数据
	 * @param map
	 * @return CartList类型的List
	 */
	@Override
	public List<CartList> loadCart(Map<String, Object> map) {
		System.out.println(map);
		return cartMapper.loadCart(map);
	}

	/**
	 * @note 购物车更新所选商品个数
	 * @param map
	 * @return 标识操作成功与否（0，1）
	 */
	@Override
	public int updateQuantity(Map<String, Object> map) {
		return cartMapper.updateQuantity(map);
	}

	/**
	 * @note 删除购物车的操作，将isDelete置为0
	 * @param map
	 * @return 操作成功的boolean变量
	 */
	@Override
	public boolean deleteCartItem(Map<String, Object> map) {
		return cartMapper.deleteCartItem(map);
	}

	/**
	 * @bnote 商品加入购物车
	 * @param cart
	 */
	@Override
	public boolean save(Cart cart) {
		Cart scart = cartMapper.selectCart(cart);
		if (null != scart) {
			//当且仅当购物车内有此种商品并且isDelete标识为0的时候才进行Quantity相加的操作
			if(scart.getIsDelete() == 0){
				scart.setCommodityQuantity(scart.getCommodityQuantity() + cart.getCommodityQuantity());
				return cartMapper.update(scart) > 0;
			}
		}
		return cartMapper.insert(cart) > 0;
	}

	@Override
	public List<Commodity> listByCartIds(List<String> cartIds) {

		return cartMapper.selectCommodityByCartIds(cartIds);
	}

	/**
	 * @note 清空购物车，相当于批量删除
	 * @param cartIdList
	 * @return 标识操作成功与否（0，1）
	 */
	@Override
	public int clearCart(List<Object> cartIdList) {
		return cartMapper.clearCart(cartIdList);

	}

}
