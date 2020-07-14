/**
 * 
 */
package lexian.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lexian.entity.Address;
import lexian.mapper.AddressMapper;
import lexian.service.AddressService;

/**
 * @author yang990322
 *
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressMapper addressMapper;

	@Override
	public List<Address> listByCustomerId(String customerId) {

		return addressMapper.selectAddressByCustomerId(customerId);
	}

	@Override
	public Boolean save(Address address) {
		addressMapper.insert(address);
		if (address.getAddressStatus() == 0) {
			addressMapper.updateStatus(address.getUid());
		}
		Map<String, Object> params = new HashMap<>();
		params.put("addressId", address.getId());
		params.put("customerId", address.getUid());
		params.put("status", address.getAddressStatus());
		addressMapper.insertCustomerAddress(params);
		return true;
	}

	@Override
	public Boolean update(Address address) {
		if (address.getAddressStatus() == 0) {
			addressMapper.updateStatus(address.getUid());
			addressMapper.updateStatusByAddressId(String.valueOf(address.getId()), address.getUid());
		}
		return addressMapper.update(address) > 0;
	}

	@Override
	public Address getById(String id) {

		return addressMapper.selectById(id);
	}

}
