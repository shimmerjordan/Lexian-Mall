package lexian.controller;

import com.github.pagehelper.PageInfo;
import lexian.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class ShopController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-commodity-provider";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/getAllShop")
    public PageInfo<Shop> getAllShop(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/getAllShop",map,PageInfo.class);
    }

    @GetMapping("/getMaxShopId")
    public int getMaxShopId() {
        return restTemplate.getForObject(REST_PREFIX+"/getMaxShopId",Integer.class);
    }

    @PostMapping("/updateShop")
    public boolean updateShop(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/updateShop",map,Boolean.class);
    }

    @PostMapping("/deleteShop")
    public boolean deleteShop(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/deleteShop",map,Boolean.class);
    }

    @PostMapping("/insertShop")
    public boolean insertShop(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/insertShop",map,Boolean.class);
    }

    @PostMapping("/updateShopStatus0")
    public boolean updateShopStatus0(@RequestBody List<Object> list) {
        return restTemplate.postForObject(REST_PREFIX+"/updateShopStatus0",list,Boolean.class);
    }

    @PostMapping("/updateShopStatus1")
    public boolean updateShopStatus1(@RequestBody List<Object> list) {
        return restTemplate.postForObject(REST_PREFIX+"/updateShopStatus1",list,Boolean.class);

    }

    @PostMapping("/updateShopStatus2")
    public boolean updateShopStatus2(@RequestBody List<Object> list) {
        return restTemplate.postForObject(REST_PREFIX+"/updateShopStatus2",list,Boolean.class);
    }
}
