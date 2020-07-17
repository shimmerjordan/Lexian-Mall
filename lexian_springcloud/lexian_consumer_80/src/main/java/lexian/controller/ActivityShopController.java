package lexian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ActivityShopController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/insertActivityShop")
    public boolean insertActivityShop(@RequestBody Map<String, Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/insertActivityShop",map,Boolean.class);
    }
}
