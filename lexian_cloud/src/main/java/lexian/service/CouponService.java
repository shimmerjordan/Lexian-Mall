/**
 * 
 */
package lexian.service;

import java.util.List;

import lexian.entity.Coupon;

/**
 * @author yang990322
 *
 */
public interface CouponService {

	List<Coupon> listConpon(String uid);
}
