/**
 * 
 */
package lexian.service;

import java.util.List;

import lexian.entity.Address;

/**
 * @author yang990322
 *
 */
public interface AddressService {

	List<Address> listByCustomerId(String customerId);

	Boolean save(Address address);

	Boolean update(Address address);

	Address getById(String id);
}
