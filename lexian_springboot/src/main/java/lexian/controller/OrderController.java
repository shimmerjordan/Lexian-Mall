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

    /**
     * 获取满足当前条件order
     * @param map 搜索订单的条件
     * @return 满足条件的order的list
     */
    @PostMapping("/getAllOrder")
    public PageInfo<Order> getAllOrder(@RequestBody Map<String,Object> map){
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        PageHelper.startPage(pageNo,limit);
        List<Order> result = orderService.getAllOrder(map);
        PageInfo<Order> res = new PageInfo<>(result);
        System.out.print(res);
        return res;
    }

    /**
     * 获取对应时间范围内的每一天的订单数量
     * @param start 开始时间
     * @param end 结束时间
     * @return 一个数组表示每一天的订单数量
     */
    @PostMapping("/getDataRange")
    public int[] getDataRange(@RequestParam(name= "start") int start,
                              @RequestParam(name = "end") int end){
        return orderService.getDateRange(start,end);
    }

    /**
     * 添加给定信息的一条order记录
     * @param map 记录的新订单的信息
     * @return 添加是否成功
     */
    @PostMapping("/addOrder")
    public boolean addOrder(@RequestBody Map<String,Object> map){
        return orderService.addOrder(map);
    }

    /**
     * 更新订单
     * @param map 新订单的对应信息
     * @return 更新订单是否成功
     */
    @PostMapping("/updateOrder")
    public boolean updateOrder(@RequestBody Map<String,Object> map){
        return orderService.updateOrder(map);
    }

    /**
     * 根据userID获取订单列表
     * @param userID 依据的userID
     * @return userID对应的订单列表
     */
    @PostMapping("/userOrder")
    public List<Order> getUserOrder(String userID) { return orderService.getUserOrder(userID); }

    /**
     * 移动端获取顾客订单
     * @param map 顾客信息
     * @return 订单列表
     */
    @PostMapping("/getCustomerOrder")
    public List<HashMap> getCustomerOrder(@RequestBody Map<String, Object> map) {
        List<HashMap> result = orderService.getCustomerOrder(map);
        return result;
    }

    /**
     * 移动端获取顾客订单
     * @param map 顾客信息
     * @return 订单列表
     */
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

    /**
     * 删除纠纷订单
     * @param map 被删除的纠纷订单信息
     * @return 删除是否成功
     */
    @PostMapping("/DeleteJiuFenOrder")
    public boolean DeleteJiuFenOrder(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return orderService.DeleteJiuFenOrder(map);
    }

    /**
     * 更新纠纷订单信息
     * @param map 被更新的纠纷订单信息
     * @return 更新是否成功
     */
    @PostMapping("/UpdateJiuFenOrder")
    public boolean UpdateJiuFenOrder(@RequestBody Map<String,Object> map){
        Date date = new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=df.format(date);
        map.put("handTime",time);
        System.out.println(map);
        return orderService.UpdateJiuFenOrder(map);
    }

    /**
     * 删除订单
     * @param index 需要被删除的订单ID
     * @return 删除是否成功
     */
    @GetMapping("/deleteOrder")
    public boolean deleteOrder(@RequestParam("index") int index){
        System.out.println(index);
        return orderService.deleteOrder(index);
    }

    /**
     * @note 取消订单接口，将取消的订单state设为9
     * @parameter  orderID
     */
    @PostMapping("/cancelCustomerOrder")
    public boolean cancelCustomerOrder(@RequestBody Map<String, Object> map){
        return orderService.cancelCustomerOrder(map);
    }


    /**
     * @note 关闭订单接口，将取消的订单isDelete设为1
     * @parameter  orderID
     */
    @PostMapping("/deleteCustomerOrder")
    public boolean deleteCustomerOrder(@RequestBody Map<String, Object> map){
        return orderService.deleteCustomerOrder(map);
    }
}
