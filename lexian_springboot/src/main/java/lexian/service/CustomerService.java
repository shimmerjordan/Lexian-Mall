package lexian.service;

import lexian.entity.Customer;

import java.util.List;
import java.util.Map;


public interface CustomerService {
    /**
     * @note 添加新用户
     * @param map
     * @return 操作成功与否boolean
     */
    boolean addNewCustomer(Map<String,Object> map);

    /**
     * @note 更新用户密码
     * @param map
     * @return 操作成功与否boolean
     */
    boolean updateCustomerPwd(Map<String,Object> map);

    /**
     * @note 根据手机号提取用户数据用于登录
     * @param map
     * @return Customer类型的List
     */
    List<Customer> loginByPhone(Map<String,Object> map);

    /**
     * @note 根据唯一标识的登录名提取用户数据用于登录
     * @param map
     * @return Customer类型的List
     */
    List<Customer> loginByName(Map<String,Object> map);

    /**
     * @note 查询数据库中是否存在本手机号
     * @param map
     * @return 标识结果的（0，1）
     */
    int checkPhoneExistance(Map<String,Object> map);

    /**
     * @note 查询数据库中是否存在登录名（用于登录）
     * @param map
     * @return 标识结果的（0，1）
     */
    int checkNameExistance(Map<String,Object> map);

    /**
     * @note 实名认证的操作，添加身份证号
     * @param map
     * @return 操作成功与否boolean
     */
    boolean setCertificationId(Map<String, Object> map);

    /**
     * @note 根据用户ID查找相关信息
     * @param id
     * @return 操作成功与否boolean
     */
    List<Customer> getById(String id);

    /**
     * @note 修改用户信息的操作
     * @param map
     * @return 操作成功与否boolean
     */
    boolean updateUserInfo(Map<String, Object> map);
}
