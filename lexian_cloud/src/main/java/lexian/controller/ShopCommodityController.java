package lexian.controller;

import lexian.entity.Commodity;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopCommodityController {
    private CommodityService commodityService;

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @RequestMapping("/api/shop/goodsInfo")
    public List<Commodity> getAllShopCommodity(){
        return commodityService.getAllShopCommodity();
    }

}
