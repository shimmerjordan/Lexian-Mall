/**
 * 
 */
package lexian.service;

import lexian.entity.Coupon;

import java.util.List;

/**
 * @author yang990322
 *
 */
public interface CouponService {

	List<Coupon> listConpon(String uid);
}
