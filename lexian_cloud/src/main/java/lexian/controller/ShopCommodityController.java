package lexian.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.Commodity;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public PageInfo<Commodity> getAllShopCommodity(@RequestParam("pageNo") Integer pageNo){
        if(pageNo==null)
            pageNo=1;
        PageHelper.startPage(pageNo,10);
        List<Commodity> resultList = commodityService.getAllShopCommodity();
        PageInfo<Commodity> result = new PageInfo<>(resultList);
        return result;
    }

}
