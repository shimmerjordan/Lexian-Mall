package lexian.service;


import lexian.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    boolean addNewCustomer(Map<String,Object> map);
    String getPwdByName(Map<String,Object> map);
    List<Customer> getUserInfo(Map<String,Object> map);
    boolean checkLoginName(String loginName);
    boolean checkPhone(String phone);
}
