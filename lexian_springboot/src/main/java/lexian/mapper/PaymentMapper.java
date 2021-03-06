/**
 * 
 */
package lexian.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import lexian.entity.Order;
import lexian.entity.model.GoodDetailsModel;
import org.springframework.stereotype.Repository;

/**
 * @author yang990322
 *
 */
@Repository
public interface PaymentMapper {

	int insertOrder(Order order);

	int insertShopOrder(@Param("shopIds") List<String> shopIds, @Param("orderId") Integer orderId);

	int insertOrderItem(@Param("gdms") List<GoodDetailsModel> gdms, @Param("orderId") Integer orderId);

	int insertOrderAddress(Map<String, Object> params);

	int insertCustomeOrder(Map<String, Object> params);
	
	int insertBill(Map<String, Object> params);
	
	int insertWalletBill(Map<String, Object> params);
	
	int updateBalance(Map<String, Object> params);
	
	int updateOrderStatus(Map<String, Object> map);
}
