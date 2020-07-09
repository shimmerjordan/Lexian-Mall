package lexian.mapper;

import lexian.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CustomerMapper {
    boolean addNewCustomer(Map<String,Object> map);
    boolean updateCustomerPwd(Map<String,Object> map);
    List<Customer> loginByPhone(Map<String,Object> map);
    int checkNameExistance(Map<String,Object> map);
    int checkPhoneExistance(Map<String,Object> map);
    List<Customer> loginByName(Map<String,Object> map);
}