package lexian.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.Commodity;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/api/shop/goodsInfo")
    public List<Commodity> getAllShopCommodity() {
        return commodityService.getAllShopCommodity();
    }

    @PostMapping("/api/shop/updateGood")
    public boolean updateGood(@RequestParam Map<String,Object> map){
//        commodityService.updateGood(updateGood);
//        return commodityService.getAllShopCommodity();
        System.out.println(map);
        System.out.println(commodityService.updateGood(map));
        return commodityService.updateGood(map);
    }
}
//    public PageInfo<Commodity> getAllShopCommodity(@RequestParam("pageNo") Integer pageNo){
//        if(pageNo==null)
//            pageNo=1;
//        PageHelper.startPage(pageNo,10);
//        List<Commodity> resultList = commodityService.getAllShopCommodity();
//        PageInfo<Commodity> result = new PageInfo<>(resultList);
//        return result;

