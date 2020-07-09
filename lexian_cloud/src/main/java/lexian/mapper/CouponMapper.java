/**
 * 
 */
package lexian.mapper;

import java.util.List;

import lexian.entity.Coupon;

/**
 * @author yang990322
 *
 */
public interface CouponMapper {

	List<Coupon> selectCouponByUid(String uid);
	
}
