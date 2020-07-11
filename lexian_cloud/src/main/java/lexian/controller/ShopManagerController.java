package lexian.controller;

import lexian.entity.ShopManager;
import lexian.service.ShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ShopManagerController {
    private ShopManagerService shopManagerService;

    @Autowired
    public void setShopManagerService(ShopManagerService shopManagerService){
        this.shopManagerService = shopManagerService;
    }

    @GetMapping("/searchShopManager")
    public List<ShopManager> searchShopManager(@RequestBody Map<String,Object> map){
        return shopManagerService.searchShopManager(map);
    }
}
