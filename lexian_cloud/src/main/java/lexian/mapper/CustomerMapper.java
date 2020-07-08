package lexian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface CustomerMapper {
    boolean addNewCustomer(Map<String,Object> map);
    String getPwdByName(String loginName);
    boolean checkLoginName(String loginName);
    boolean checkPhone(String phone);
}