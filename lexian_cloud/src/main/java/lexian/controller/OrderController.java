package lexian.controller;

import lexian.entity.Order;
import lexian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAllOrder")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping("/getDataRange")
    public int[] getDataRange(@RequestParam(name= "start") int start,
                              @RequestParam(name = "end") int end){
        return orderService.getDateRange(start,end);
    }

    @PostMapping("/addOrder")
    public boolean addOrder(@RequestBody Map<String,Object> map){
        return orderService.addOrder(map);
    }

}
