/**
 * 
 */
package lexian.mapper;

import lexian.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yang990322
 *
 */
public interface AddressMapper {

	List<Address> selectAddressByCustomerId(String customerId);

	int insert(Address address);
	
	int update(Address address);

	int insertCustomerAddress(Map<String, Object> params);
	
	void updateStatus(String uid);
	
	void updateStatusByAddressId(@Param("addressId")String addressId,@Param("uid")String uid);
	
	Address selectById(String id);
}
