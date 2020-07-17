package lexian.controller;

import com.github.pagehelper.PageInfo;
import lexian.entity.Category;
import lexian.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class ShopCommodityController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/api/shop/goodsInfo")
    public PageInfo<Commodity> getAllShopCommodity(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/api/shop/goodsInfo",map,PageInfo.class);
    }

    @PostMapping("/api/shop/updateGood")
    public boolean updateGood(@RequestBody Map<String, Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/api/shop/updateGood",map,Boolean.class);
    }

    @PostMapping("/api/shop/deleteGood")
    public boolean deleteGood(@RequestBody Map<String, Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/api/shop/deleteGood",map,Boolean.class);
    }

    @PostMapping("/api/shop/addGood")
    public boolean addGood(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/api/shop/addGood",map,Boolean.class);
    }

    @PostMapping("/api/shop/getAllCategory")
    public List<Category> getAllCategory(){
        return restTemplate.postForObject(REST_PREFIX+"/api/shop/getAllCategory",null,List.class);
    }

}

