/**
 * 
 */
package lexian.service.serviceImpl;

import java.util.List;

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

}
