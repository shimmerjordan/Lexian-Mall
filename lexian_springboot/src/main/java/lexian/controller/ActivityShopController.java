package lexian.controller;

import lexian.entity.ActivityShop;
import lexian.service.ActivityShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ActivityShopController {
    private ActivityShopService activityShopService;

    @Autowired
    public void setActivityShopService(ActivityShopService activityShopService) {
        this.activityShopService = activityShopService;
    }
    @PostMapping("/insertActivityShop")
    public boolean insertActivityShop(@RequestBody Map<String, Object>map) {
        System.out.println(map);
        return activityShopService.insertActivityShop(map);
    }
}
