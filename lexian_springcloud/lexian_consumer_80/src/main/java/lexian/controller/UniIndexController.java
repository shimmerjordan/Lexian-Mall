package lexian.controller;

import lexian.entity.Activity;
import lexian.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/uniIndex")
public class UniIndexController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider/uniIndex";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/init")
    public List<Commodity> getIndexCommodity() {
        return restTemplate.getForObject(REST_PREFIX+"/init",List.class);
    }


    @GetMapping("/getActivity")
    public List<Activity> IndexActivity() {
        return restTemplate.getForObject(REST_PREFIX+"/getActivity",List.class);
    }

    @PostMapping("/indexSearch")
    public List<Commodity> indexSearch(@RequestBody Map<String,Object> map){
        return restTemplate.postForObject(REST_PREFIX+"/indexSearch",map,List.class);
    }



}