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
	
	@Autowired
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/loginByPhone")
    public List<Customer> loginByPhone(@RequestBody Map<String,Object> map){
        System.out.println(map);
        System.out.println(customerService.loginByPhone(map));
        return customerService.loginByPhone(map);
    }

    @PostMapping("/loginByName")
    public List<Customer> loginByName(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return customerService.loginByName(map);
    }

    @PostMapping("/checkPhoneExistance")
    public int checkPhoneExistance(@RequestBody Map<String,Object> map) {
        return customerService.checkPhoneExistance(map);
    }

    @PostMapping("/checkNameExistance")
    public int checkNameExistance(@RequestBody Map<String,Object> map){
        return customerService.checkNameExistance(map);
    }

    @PostMapping("/addNewCustomer")
    public boolean addNewCustomer(@RequestBody Map<String,Object> map){
        return customerService.addNewCustomer(map);
    }

    @PostMapping("/updateCustomerPwd")
    public boolean updateCustomerPwd(@RequestBody Map<String,Object> map){
        return customerService.updateCustomerPwd(map);
    }

}
