package lexian.controller;

import lexian.entity.ShopManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class ShopManagerController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @PostMapping("/searchShopManager")
    public List<ShopManager> searchShopManager(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/searchShopManager",map,List.class);
    }

    @PostMapping("/updateShopManager")
    public boolean updateShopManager(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/updateShopManager",map,Boolean.class);
    }

    @PostMapping("/deleteShopManager")
    public boolean deleteShopManager(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/deleteShopManager",map,Boolean.class);
    }
}
