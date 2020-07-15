/**
 * 
 */
package lexian.mapper;

import lexian.entity.Coupon;

import java.util.List;

/**
 * @author yang990322
 *
 */
public interface CouponMapper {

	List<Coupon> selectCouponByUid(String uid);
	
}
