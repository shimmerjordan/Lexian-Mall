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
    List<HashMap> getCustomerOrder(Map<String, Object> map);
    List<JiuFenOrder> getJiuFenOrder();
    List<JiuFenOrder> getJiuFenOrderByID(Integer id);
    boolean DeleteJiuFenOrder(Map<String,Object> map);
    boolean UpdateJiuFenOrder(Map<String,Object> map);
    boolean deleteOrder(int i);
}
