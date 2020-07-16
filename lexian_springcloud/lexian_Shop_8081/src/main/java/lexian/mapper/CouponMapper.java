/**
 * 
 */
package lexian.mapper;

import lexian.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yang990322
 *
 */
@Repository
@Mapper
public interface CouponMapper {

	List<Coupon> selectCouponByUid(String uid);
	
}
