/**
 * 
 */
package lexian.service;

import lexian.entity.Address;

import java.util.List;

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
