package lexian.service.serviceImpl;

import lexian.mapper.CustomerMapper;
import lexian.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;

    @Override
    public boolean addNewCustomer(Map<String, Object> map) {
        return customerMapper.addNewCustomer(map);
    }

    @Override
    public String getPwdByName(String name) {
        return customerMapper.getPwdByName(name);
    }

    @Override
    public boolean checkLoginName(String loginName) {
        return customerMapper.checkLoginName(loginName);
    }

    @Override
    public boolean checkPhone(String phone) {
        return customerMapper.checkPhone(phone);
    }
}
