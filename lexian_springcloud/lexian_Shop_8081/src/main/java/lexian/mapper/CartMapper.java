package lexian.mapper;

import lexian.entity.Cart;
import lexian.entity.CartList;
import lexian.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CartMapper {

	int insert(Cart record);

	List<CartList> loadCart(Map<String, Object> map);

	Cart selectCart(Cart record);
	
	int update(Cart cart);

	List<Commodity> selectCommodityByCartIds(@Param("cartIds")List<String> cartIds);

    int updateQuantity(Map<String, Object> map);

    boolean deleteCartItem(Map<String, Object> map);

    int clearCart(List<Object> cartIdList);
}