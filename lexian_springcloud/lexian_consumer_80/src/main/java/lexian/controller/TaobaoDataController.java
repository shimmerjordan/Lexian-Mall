package lexian.controller;

import com.github.pagehelper.PageInfo;
import lexian.entity.taobaoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class TaobaoDataController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-commodity-provider";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/api/getAlltaobaoGoods")
    public PageInfo<taobaoData> getAlltaobaoGoods(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/api/getAlltaobaoGoods",map,PageInfo.class);
    }

}
