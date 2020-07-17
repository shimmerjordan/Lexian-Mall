/**
 * 
 */
package lexian.controller;

import lexian.entity.Address;
import lexian.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yang990322
 *
 */
@RestController
@RequestMapping("/api/address")
public class AddressController {

    AddressService addressService;

	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@RequestMapping("/listByUid")
	public List<Address> listByUid(String uid) {
		return addressService.listByCustomerId(uid);
	}

	@RequestMapping("/save")
	public Boolean save(@RequestBody Address address) {
		System.out.println(address);
		return addressService.save(address);
	}

	@RequestMapping("/update")
	public Boolean update(@RequestBody Address address) {

		return addressService.update(address);
	}

	@RequestMapping("/getById")
	public Address getById(String id) {
		return addressService.getById(id);
	}

}
