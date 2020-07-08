package lexian.controller;


import lexian.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping("/verifyPwdByName")
    public String getPwdByName(@RequestBody String name){
        System.out.println(name);
        return customerService.getPwdByName(name);
    }




}
