package lexian.controller;

import lexian.entity.Order;
import lexian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
