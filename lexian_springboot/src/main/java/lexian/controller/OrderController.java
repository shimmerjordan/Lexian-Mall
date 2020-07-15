package lexian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.JiuFenOrder;
import lexian.entity.Order;
import lexian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    @PostMapping("/getAllOrder")
    public PageInfo<Order> getAllOrder(@RequestBody Map<String,Object> map){
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        PageHelper.startPage(pageNo,limit);
        return new PageInfo<>(orderService.getAllOrder(map));
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

    @PostMapping("/updateOrder")
    public boolean updateOrder(@RequestBody Map<String,Object> map){
        return orderService.updateOrder(map);
    }

    @PostMapping("/userOrder")
    public List<Order> getUserOrder(String userID) { return orderService.getUserOrder(userID); }

    @PostMapping("/getCustomerOrder")
    public List<HashMap> getCustomerOrder(@RequestBody Map<String, Object> map) {
        List<HashMap> result = orderService.getCustomerOrder(map);
        return result;
    }

    @PostMapping("/jiufenOrder")
    public PageInfo<JiuFenOrder> getJiuFenOrder(@RequestBody Map<String,Object> map){
        System.out.println(map);
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        PageHelper.startPage(pageNo,limit);
        List<JiuFenOrder> resultList;
        String id= (String)map.get("name");
        System.out.println(id);
        if(id!=""){
            Integer orderid=Integer.parseInt(id);
            System.out.println(id);
            resultList = orderService.getJiuFenOrderByID(orderid);
        }
        else {
            resultList = orderService.getJiuFenOrder();
        }
        PageInfo<JiuFenOrder> result = new PageInfo<>(resultList);
        System.out.print(result);
        return result;
    }

    @PostMapping("/DeleteJiuFenOrder")
    public boolean DeleteJiuFenOrder(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return orderService.DeleteJiuFenOrder(map);
    }

    @PostMapping("/UpdateJiuFenOrder")
    public boolean UpdateJiuFenOrder(@RequestBody Map<String,Object> map){
        Date date = new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=df.format(date);
        map.put("handTime",time);
        System.out.println(map);
        return orderService.UpdateJiuFenOrder(map);
    }
}
