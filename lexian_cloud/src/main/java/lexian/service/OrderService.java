package lexian.service;

import lexian.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();
    int[] getDateRange(int start, int end);
}
