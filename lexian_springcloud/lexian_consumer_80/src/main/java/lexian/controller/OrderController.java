package lexian.controller;

import com.github.pagehelper.PageInfo;
import lexian.entity.JiuFenOrder;
import lexian.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-commodity-provider/order";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/getAllOrder")
    public PageInfo<Order> getAllOrder(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/getAllOrder",map,PageInfo.class);
    }

    @PostMapping("/addOrder")
    public boolean addOrder(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/addOrder",map,Boolean.class);
    }

    @PostMapping("/updateOrder")
    public boolean updateOrder(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/updateOrder",map,Boolean.class);
    }

    @PostMapping("/userOrder")
    public List<Order> getUserOrder(String userID) {
        return restTemplate.postForObject(REST_PREFIX+"/userOrder",userID,List.class);
    }

    @PostMapping("/getCustomerOrder")
    public List<HashMap> getCustomerOrder(@RequestBody Map<String, Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/getCustomerOrder",map,List.class);
    }

    @PostMapping("/jiufenOrder")
    public PageInfo<JiuFenOrder> getJiuFenOrder(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/jiufenOrder",map,PageInfo.class);
    }

    @PostMapping("/DeleteJiuFenOrder")
    public boolean DeleteJiuFenOrder(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/DeleteJiuFenOrder",map,Boolean.class);
    }

    @PostMapping("/UpdateJiuFenOrder")
    public boolean UpdateJiuFenOrder(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/UpdateJiuFenOrder",map,Boolean.class);
    }

    @GetMapping("/deleteOrder")
    public boolean deleteOrder(@RequestParam("index") int index){
        return restTemplate.getForObject(REST_PREFIX+"/deleteOrder?index={1}",Boolean.class,index);
    }

}
