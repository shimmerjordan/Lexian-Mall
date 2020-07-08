package lexian.service;

import java.util.Map;

import lexian.entity.Customer;

public interface CustomerService {
    boolean addNewCustomer(Map<String,Object> map);
    Map<String, Object> getPwdByName(String name);
    boolean checkLoginName(String loginName);
    boolean checkPhone(String phone);
}
