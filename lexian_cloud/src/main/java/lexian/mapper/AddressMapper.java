/**
 * 
 */
package lexian.mapper;

import java.util.List;

import lexian.entity.Address;

/**
 * @author yang990322
 *
 */
public interface AddressMapper {

	List<Address> selectAddressByCustomerId(String customerId);
}
