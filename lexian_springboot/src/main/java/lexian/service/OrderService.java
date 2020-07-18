package lexian.service;

import lexian.entity.JiuFenOrder;
import lexian.entity.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
public interface OrderService {
    List<Order> getAllOrder(Map<String,Object> map);
    int[] getDateRange(int start, int end);
    boolean addOrder(Map<String,Object> map);
    boolean updateOrder(Map<String,Object> map);
    List<Order> getUserOrder(String userID);

    /**
     * 移动端获取顾客订单
     * @param map 顾客信息
     * @return 订单列表
     */
    List<HashMap> getCustomerOrder(Map<String, Object> map);
    List<JiuFenOrder> getJiuFenOrder();
    List<JiuFenOrder> getJiuFenOrderByID(Integer id);
    boolean DeleteJiuFenOrder(Map<String,Object> map);
    boolean UpdateJiuFenOrder(Map<String,Object> map);
    boolean deleteOrder(int i);

    /**
     * @note 取消订单，将取消的订单state设为9
     * @parameter  orderID
     */
    boolean cancelCustomerOrder(Map<String, Object> map);

    /**
     * @note 删除订单，将取消的订单的isDelete设为1
     * @parameter  orderID
     */
    boolean deleteCustomerOrder(Map<String, Object> map);
}
