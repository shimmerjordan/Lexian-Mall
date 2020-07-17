package lexian.controller;

import lexian.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    private RestTemplate restTemplate;
    private static final String REST_PREFIX="http://lexian-zuul/lexian-commodity-provider/manager";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/all-role")
    public List<List<Manager>> getAllRole(){
        return restTemplate.getForObject(REST_PREFIX+"/all-role",List.class);
    }

    @PostMapping("/add")
    public boolean addManager(@RequestBody Map<String,Object> m){
        return restTemplate.postForObject(REST_PREFIX+"/add",m,Boolean.class);
    }

    @PostMapping("/update")
    public boolean updateManager(@RequestBody Map<String,Object> m){
        return restTemplate.postForObject(REST_PREFIX+"/update",m,Boolean.class);
    }

    @GetMapping("/delete")
    public boolean deleteManager(@RequestParam int index){
        return restTemplate.getForObject(REST_PREFIX+"/delete?index={1}",Boolean.class,index);
    }
}
