package lexian.service.serviceImpl;

import lexian.entity.Customer;
import lexian.mapper.CustomerMapper;
import lexian.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public boolean addNewCustomer(Map<String, Object> map) {
        return customerMapper.addNewCustomer(map);
    }

    @Override
    public String getPwdByName(Map<String,Object> map) {
        return customerMapper.getPwdByName(map);
    }

    @Override
    public boolean checkLoginName(String loginName) {
        return customerMapper.checkLoginName(loginName);
    }

    @Override
    public boolean checkPhone(String phone) {
        return customerMapper.checkPhone(phone);
    }

    @Override
    public List<Customer> getUserInfo(Map<String, Object> map) {
        return customerMapper.getUserInfo(map);
    }
}
