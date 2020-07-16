package lexian.controller;

import lexian.entity.ShopManager;
import lexian.service.ShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/searchShopManager")
    public List<ShopManager> searchShopManager(@RequestBody Map<String,Object> map){
//        System.out.println(map);
        List<ShopManager> result=shopManagerService.searchShopManager(map);
//        System.out.println(result);
        return result;
    }

    @PostMapping("/updateShopManager")
    public boolean updateShopManager(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return shopManagerService.updateShopManager(map);
    }

    @PostMapping("/deleteShopManager")
    public boolean deleteShopManager(@RequestBody Map<String,Object> map) {
        return shopManagerService.deleteShopManager(map);
    }
}
