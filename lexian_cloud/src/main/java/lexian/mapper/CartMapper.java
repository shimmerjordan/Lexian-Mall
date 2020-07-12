package lexian.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import lexian.entity.Cart;
import lexian.entity.CartList;

@Repository
public interface CartMapper {

	int insert(Cart record);

	List<CartList> loadCart(Map<String, Object> map);

	Cart selectCart(Cart record);
	
	int update(Cart cart);

}