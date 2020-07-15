/**
 * 
 */
package lexian.service.serviceImpl;

import lexian.entity.Coupon;
import lexian.mapper.CouponMapper;
import lexian.service.CouponService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang990322
 *
 */
@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponMapper couponMapper;

	@Override
	public List<Coupon> listConpon(String uid) {
		if (StringUtils.isNoneBlank(uid)) {
			return couponMapper.selectCouponByUid(uid);
		}
		return null;
	}

}
