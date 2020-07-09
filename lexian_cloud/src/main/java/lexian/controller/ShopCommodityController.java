package lexian.controller;

import lexian.entity.Category;
import lexian.entity.Commodity;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ShopCommodityController {
    private CommodityService commodityService;

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/api/shop/goodsInfo")
    public List<Commodity> getAllShopCommodity() {
        return commodityService.getAllShopCommodity();
    }

    @PostMapping("/api/shop/updateGood")
    public boolean updateGood(@RequestBody Map<String, Object> map) {
//        commodityService.updateGood(updateGood);
//        return commodityService.getAllShopCommodity();
        System.out.println(map);
        System.out.println(commodityService.updateGood(map));
        return commodityService.updateGood(map);
    }

    @PostMapping("/api/shop/deleteGood")
    public boolean deleteGood(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        return commodityService.deleteGood(map);
    }

    @PostMapping("/api/shop/addGood")
    public boolean addGood(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return commodityService.addGood(map);
    }

    @PostMapping("/api/shop/getAllCategory")
    public List<Category> getAllCategory(){
        List<Category> result = commodityService.getAllCategory();
        System.out.println(result);
        return result;
    }

}
//    public PageInfo<Commodity> getAllShopCommodity(@RequestParam("pageNo") Integer pageNo){
//        if(pageNo==null)
//            pageNo=1;
//        PageHelper.startPage(pageNo,10);
//        List<Commodity> resultList = commodityService.getAllShopCommodity();
//        PageInfo<Commodity> result = new PageInfo<>(resultList);
//        return result;

