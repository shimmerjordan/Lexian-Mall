package lexian.controller;

import lexian.entity.Commodity;
import lexian.entity.UniBrowsingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/uniUser")
public class UniUserController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider/uniUser";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/getHistory")
    public List<UniBrowsingRecord> getUserHistory(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/getHistory",map,List.class);
    }

    @PostMapping("/getFavorites")
    public List<Commodity> getUserFavorites(@RequestBody Map<String,Object> map) {
        return restTemplate.postForObject(REST_PREFIX+"/getFavorites",map,List.class);
    }
}
