package lexian.controller;

import lexian.entity.Customer;
import lexian.service.CustomerService;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * @note 根据手机号提取用户数据用于登录
	 * @param map
	 * @return Customer类型的List
	 */
	@PostMapping("/loginByPhone")
	public List<Customer> loginByPhone(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		System.out.println(customerService.loginByPhone(map));
		return customerService.loginByPhone(map);
	}

	/**
	 * @note 根据唯一标识的登录名提取用户数据用于登录
	 * @param map
	 * @return Customer类型的List
	 */
	@PostMapping("/loginByName")
	public List<Customer> loginByName(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		return customerService.loginByName(map);
	}

	/**
	 * @note 查询数据库中是否存在本手机号
	 * @param map
	 * @return 标识结果的（0，1）
	 */
	@PostMapping("/checkPhoneExistance")
	public int checkPhoneExistance(@RequestBody Map<String, Object> map) {
		return customerService.checkPhoneExistance(map);
	}

	/**
	 * @note 查询数据库中是否存在登录名（用于登录）
	 * @param map
	 * @return 标识结果的（0，1）
	 */
	@PostMapping("/checkNameExistance")
	public int checkNameExistance(@RequestBody Map<String, Object> map) {
		return customerService.checkNameExistance(map);
	}

	/**
	 * @note 添加新用户
	 * @param map
	 * @return 操作成功与否boolean
	 */
	@PostMapping("/addNewCustomer")
	public boolean addNewCustomer(@RequestBody Map<String, Object> map) {
		return customerService.addNewCustomer(map);
	}

	/**
	 * @note 更新用户密码
	 * @param map
	 * @return 操作成功与否boolean
	 */
	@PostMapping("/updateCustomerPwd")
	public boolean updateCustomerPwd(@RequestBody Map<String, Object> map) {
		return customerService.updateCustomerPwd(map);
	}

	/**
	 * @note 根据用户ID查找相关信息
	 * @param uid
	 * @return 操作成功与否boolean
	 */
	@RequestMapping("/getById")
	public List<Customer> getById(String uid) {
		return customerService.getById(uid);
	}

	/**
	 * @note 实名认证的操作，添加身份证号
	 * @param map
	 * @return 操作成功与否boolean
	 */
	@RequestMapping("/setCertificationId")
	public boolean setCertificationId(@RequestBody Map<String, Object> map){
		System.out.println(map);
		return customerService.setCertificationId(map);
	}

	/**
	 * @note 修改用户信息的操作
	 * @param map
	 * @return 操作成功与否boolean
	 */
	@PostMapping("/updateUserInfo")
	public boolean updateUserInfo(@RequestBody Map<String, Object> map){
		System.out.println(map);
		return customerService.updateUserInfo(map);
	}
}
