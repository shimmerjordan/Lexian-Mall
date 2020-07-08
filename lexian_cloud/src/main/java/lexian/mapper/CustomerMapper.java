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
    String getPwdByName(Map<String,Object> map);
    boolean checkLoginName(String loginName);
    boolean checkPhone(String phone);
    List<Customer> getUserInfo(Map<String,Object> map);
}