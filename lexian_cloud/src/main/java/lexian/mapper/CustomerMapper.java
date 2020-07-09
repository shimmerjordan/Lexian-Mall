package lexian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import lexian.entity.Customer;

import java.util.Map;

@Mapper
@Repository
public interface CustomerMapper {
    boolean addNewCustomer(Map<String,Object> map);
    Map<String, Object> getPwdByName(String loginName);
    boolean checkLoginName(String loginName);
    boolean checkPhone(String phone);
}