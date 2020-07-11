package lexian.mapper;

import lexian.entity.Cart;
import lexian.entity.CartList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CartMapper {

    int insert(Cart record);

    List<CartList> loadCart(Map<String, Object> map);
}