package lexian.service.serviceImpl;

import lexian.entity.Order;
import lexian.mapper.OrderMapper;
import lexian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper){
        this.orderMapper=orderMapper;
    }

    @Override
    public List<Order> getAllOrder(){
        return orderMapper.getAllOrder();
    }
}
