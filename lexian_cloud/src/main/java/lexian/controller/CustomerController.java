package lexian.controller;


import lexian.entity.Customer;
import lexian.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/verifyPwdByName")
    public String getPwdByName(@RequestBody Map<String,Object> map){
        System.out.println(map);
        System.out.println(customerService.getPwdByName(map));
        return customerService.getPwdByName(map);
    }

    @PostMapping("/register")
    public List<Customer> getUserInfo(@RequestBody Map<String,Object> map){
        System.out.println(map);
        System.out.println(customerService.getUserInfo(map));
        return customerService.getUserInfo(map);
    }



}
