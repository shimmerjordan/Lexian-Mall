package lexian.controller;

import lexian.entity.Shop;
import lexian.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

//    @GetMapping("/updateShop")
//    public List<Shop> updateShop(Shop record) {
//        return shopService.updateShop(record);
//    }
}
