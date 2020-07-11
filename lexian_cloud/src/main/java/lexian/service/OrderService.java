package lexian.service;

import lexian.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getAllOrder();
    int[] getDateRange(int start, int end);
    boolean addOrder(Map<String,Object> map);
    boolean updateOrder(Map<String,Object> map);
    List<Order> getUserOrder(String userID);
}
