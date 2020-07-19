package lexian.service.serviceImpl;

import lexian.entity.Customer;
import lexian.mapper.CustomerMapper;
import lexian.service.CustomerService;

import lombok.Builder;
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

    /**
     * @note 添加新用户
     * @param map
     * @return 操作成功与否boolean
     */
    @Override
    public boolean addNewCustomer(Map<String, Object> map) {
        return customerMapper.addNewCustomer(map);
    }

    /**
     * @note 更新用户密码
     * @param map
     * @return 操作成功与否boolean
     */
    @Override
    public boolean updateCustomerPwd(Map<String, Object> map) {
        return customerMapper.updateCustomerPwd(map);
    }

    /**
     * @note 根据手机号提取用户数据用于登录
     * @param map
     * @return Customer类型的List
     */
    @Override
    public List<Customer> loginByPhone(Map<String,Object> map) {
        map.put("code",(int)((Math.random()) * 1000000));
        return customerMapper.loginByPhone(map);
    }

    /**
     * @note 查询数据库中是否存在本手机号
     * @param map
     * @return 标识结果的（0，1）
     */
    @Override
    public int checkPhoneExistance(Map<String, Object> map) {
        return customerMapper.checkPhoneExistance(map);
    }

    /**
     * @note 查询数据库中是否存在登录名（用于登录）
     * @param map
     * @return 标识结果的（0，1）
     */
    @Override
    public int checkNameExistance(Map<String, Object> map) {
        return  customerMapper.checkNameExistance(map);
    }

    /**
     * @note 实名认证的操作，添加身份证号
     * @param map
     * @return 操作成功与否boolean
     */
    @Override
    public boolean setCertificationId(Map<String, Object> map) {
        return customerMapper.setCertificationId(map);
    }

    /**
     * @note 根据唯一标识的登录名提取用户数据用于登录
     * @param map
     * @return Customer类型的List
     */
    @Override
    public List<Customer> loginByName(Map<String, Object> map) {
        return customerMapper.loginByName(map);
    }

    /**
     * @note 根据用户ID查找相关信息
     * @param id
     * @return 操作成功与否boolean
     */
	@Override
	public Customer getById(String id) {
		return customerMapper.selectById(id);
	}

    /**
     * @note 修改用户信息的操作
     * @param map
     * @return 操作成功与否boolean
     */
	@Override
    public boolean updateUserInfo(Map<String, Object> map){
        return customerMapper.updateUserInfo(map);
    }
}
