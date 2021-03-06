package lexian.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import lexian.entity.Cart;
import lexian.entity.CartList;
import lexian.entity.Commodity;

@Repository
public interface CartMapper {

	/**
	 * @bnote 商品加入购物车
	 * @param record
	 */
	int insert(Cart record);

	/**
	 * @note 加载购物车数据
	 * @param map
	 * @return CartList类型的List
	 */
	List<CartList> loadCart(Map<String, Object> map);

	Cart selectCart(Cart record);
	
	int update(Cart cart);

	List<Commodity> selectCommodityByCartIds(@Param("cartIds")List<String> cartIds);

	/**
	 * @note 购物车更新所选商品个数
	 * @param map
	 * @return 标识操作成功与否（0，1）
	 */
    int updateQuantity(Map<String, Object> map);

	/**
	 * @note 删除购物车的操作，将isDelete置为0
	 * @param map
	 * @return 操作成功的boolean变量
	 */
    boolean deleteCartItem(Map<String, Object> map);

	/**
	 * @note 清空购物车，相当于批量删除
	 * @param cartIdList
	 * @return 标识操作成功与否（0，1）
	 */
    int clearCart(List<Object> cartIdList);
}