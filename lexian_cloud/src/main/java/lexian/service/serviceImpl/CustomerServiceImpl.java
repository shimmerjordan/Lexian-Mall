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

	@Autowired
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
    public boolean updateCustomerPwd(Map<String, Object> map) {
        return customerMapper.updateCustomerPwd(map);
    }

    @Override
    public List<Customer> loginByPhone(Map<String,Object> map) {
        map.put("code",(int)((Math.random()) * 1000000));
        return customerMapper.loginByPhone(map);
    }

    @Override
    public int checkPhoneExistance(Map<String, Object> map) {
        return customerMapper.checkPhoneExistance(map);
    }

    @Override
    public int checkNameExistance(Map<String, Object> map) {
        return  customerMapper.checkNameExistance(map);
    }

    @Override
    public List<Customer> loginByName(Map<String, Object> map) {
        return customerMapper.loginByName(map);
    }
}
