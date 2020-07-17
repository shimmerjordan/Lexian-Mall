/**
 * 
 */
package lexian.controller;

import lexian.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yang990322
 *
 */
@RestController
@RequestMapping("/api/address")
public class AddressController {

	private RestTemplate restTemplate;
	private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider/api/address";

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping("/listByUid")
	public List<Address> listByUid(String uid) {
		return restTemplate.postForObject(REST_PREFIX+"/listByUid",uid,List.class);
	}

	@RequestMapping("/save")
	public Boolean save(@RequestBody Address address) {
		return restTemplate.postForObject(REST_PREFIX+"/save",address,Boolean.class);
	}

	@RequestMapping("/update")
	public Boolean update(@RequestBody Address address) {
		return restTemplate.postForObject(REST_PREFIX+"/update",address,Boolean.class);
	}

	@RequestMapping("/getById")
	public Address getById(String id) {
		return restTemplate.postForObject(REST_PREFIX+"/getById",id,Address.class);
	}

}
