package lexian.service;

import java.util.Map;

public interface CustomerService {
    boolean addNewCustomer(Map<String,Object> map);
    String getPwdByName(String name);
    boolean checkLoginName(String loginName);
    boolean checkPhone(String phone);
}
