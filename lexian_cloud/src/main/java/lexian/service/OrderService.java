package lexian.service;

import lexian.entity.JiuFenOrder;
import lexian.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getAllOrder(Map<String,Object> map);
    int[] getDateRange(int start, int end);
    boolean addOrder(Map<String,Object> map);
    boolean updateOrder(Map<String,Object> map);
    List<Order> getUserOrder(String userID);
    List<JiuFenOrder> getJiuFenOrder();
    List<JiuFenOrder> getJiuFenOrderByID(Integer id);
    boolean DeleteJiuFenOrder(Map<String,Object> map);
    boolean UpdateJiuFenOrder(Map<String,Object> map);
}
