package lexian.service;

import lexian.entity.Customer;

import java.util.List;
import java.util.Map;


public interface CustomerService {
    boolean addNewCustomer(Map<String,Object> map);
    boolean updateCustomerPwd(Map<String,Object> map);
    List<Customer> loginByPhone(Map<String,Object> map);
    List<Customer> loginByName(Map<String,Object> map);
    int checkPhoneExistance(Map<String,Object> map);
    int checkNameExistance(Map<String,Object> map);
    
    Customer getById(String id);

}
