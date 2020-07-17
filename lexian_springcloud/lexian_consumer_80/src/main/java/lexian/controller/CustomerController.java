package lexian.controller;

import lexian.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private RestTemplate restTemplate;
	private static final String REST_PREFIX="http://lexian-zuul/lexian-commodity-provider/customer";
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@PostMapping("/loginByPhone")
	public List<Customer> loginByPhone(@RequestBody Map<String, Object> map) {
		return restTemplate.postForObject(REST_PREFIX+"/loginByPhone",map,List.class);
	}

	@PostMapping("/loginByName")
	public List<Customer> loginByName(@RequestBody Map<String, Object> map) {
		return restTemplate.postForObject(REST_PREFIX+"/loginByName",map,List.class);
	}

	@PostMapping("/checkPhoneExistance")
	public int checkPhoneExistance(@RequestBody Map<String, Object> map) {
		return restTemplate.postForObject(REST_PREFIX+"/checkPhoneExistance",map,Integer.class);
	}

	@PostMapping("/checkNameExistance")
	public int checkNameExistance(@RequestBody Map<String, Object> map) {
		return restTemplate.postForObject(REST_PREFIX+"/checkNameExistance",map,Integer.class);
	}

	@PostMapping("/addNewCustomer")
	public boolean addNewCustomer(@RequestBody Map<String, Object> map) {
		return restTemplate.postForObject(REST_PREFIX+"/addNewCustomer",map,Boolean.class);
	}

	@PostMapping("/updateCustomerPwd")
	public boolean updateCustomerPwd(@RequestBody Map<String, Object> map) {
		return restTemplate.postForObject(REST_PREFIX+"/updateCustomerPwd",map,Boolean.class);
	}

	@RequestMapping("/getById")
	public Customer getById(String uid) {
		return restTemplate.postForObject(REST_PREFIX+"/getById",uid,Customer.class);
	}

	@RequestMapping("/setCertificationId")
	public boolean setCertificationId(@RequestBody Map<String, Object> map){
		return restTemplate.postForObject(REST_PREFIX+"/setCertificationId",map,Boolean.class);
	}
}
