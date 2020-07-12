package lexian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.Shop;
import lexian.service.ShopService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ShopController {
    private ShopService shopService;


    @Autowired
    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }


    @PostMapping("/getAllShop")
    public PageInfo<Shop> getAllShop(@RequestBody Map<String,Object> map) {
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        PageHelper.startPage(pageNo,limit);
        List<Shop> resultList;
        String name=(String)map.get("name");
        String id = (String)map.get("id");
        String beginTime = (String) map.get("beginTime");
        String endTime = (String) map.get("endTime");
        String status = (String)map.get("status");
        if(name!=null || id != null || status != null
                || (beginTime != null && endTime !=null)){
            String changeName="%"+name+"%";
            map.put("name",changeName);
//            map.put("status",changeStatus);
            System.out.println(map);
            resultList = shopService.searchShopByInformation(map);
        }
        else {
            resultList = shopService.getAllShop();
        }
        PageInfo<Shop> result = new PageInfo<>(resultList);
        System.out.print(result);
        return result;
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

    @PostMapping("/deleteShop")
    public boolean deleteShop(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return shopService.deleteShop(map);
    }

    @PostMapping("/insertShop")
    public boolean insertShop(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return shopService.insertShop(map);
    }

    @PostMapping("/updateShopStatus0")
    public boolean updateShopStatus0(@RequestBody List<Object> list) {
//        for (int i = 0; i <= array.size(); i++) {
//            Map<String,Object> map = array[i];
//            return shopService.updateShopStstus0(map);
//        }
        System.out.println(list);
        return shopService.updateShopStatus0(list);

    }

    @PostMapping("/updateShopStatus1")
    public boolean updateShopStatus1(@RequestBody List<Object> list) {
        System.out.println(list);
        return shopService.updateShopStatus1(list);

    }

    @PostMapping("/updateShopStatus2")
    public boolean updateShopStatus2(@RequestBody List<Object> list) {
        System.out.println(list);
        return shopService.updateShopStatus2(list);

    }
}
