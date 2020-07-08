package lexian.controller;

import lexian.entity.Shop;
import lexian.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ShopController {
    private ShopService shopService;


    @Autowired
    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }


    @GetMapping("/getAllShop")
    public List<Shop> getAllShop() {
        return shopService.getAllShop();
    }

    @GetMapping("/getMaxShopId")
    public int getMaxShopId() {
        return shopService.getMaxShopId();
    }

    @PostMapping("/updateShop")
    public boolean updateShop(@RequestBody Map<String,Object> map){
//        commodityService.updateGood(updateGood);
//        return commodityService.getAllShopCommodity();
        System.out.println(map);
        System.out.println(shopService.updateShop(map));
        return shopService.updateShop(map);
    }
}
