package lexian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.Shop;
import lexian.service.ShopService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.FileVisitResult;
import java.util.List;
import java.util.Map;

@RestController
public class ShopController {
    private ShopService shopService;


    @Autowired
    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }

    /**
     * 获取全部店铺信息
     * @param map
     * @return
     */
    @PostMapping("/getAllShop")
    public PageInfo<Shop> getAllShop(@RequestBody Map<String,Object> map) {
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        PageHelper.startPage(pageNo,limit);
        List<Shop> resultList;

        //获取传入值
        String name=(String)map.get("name");
        String id = (String)map.get("id");
        String beginTime = (String) map.get("beginTime");
        String endTime = (String) map.get("endTime");
        String status = (String)map.get("status");

        //同ActivityController一致，对条件进行判断，不为空则查询；为空，获取全部值
        if(name!="" || id != "" || status != ""
                || (beginTime != "" && endTime !="")){
            String changeName="%"+name+"%";
            map.put("name",changeName);
//            map.put("status",changeStatus);
            System.out.println(map);
            resultList = shopService.searchShopByInformation(map);
            System.out.println("xxxx"+resultList);
        }
        else {
            resultList = shopService.getAllShop();
            System.out.println(resultList);
        }
        PageInfo<Shop> result = new PageInfo<>(resultList);
        System.out.print(result);
        return result;
    }

    /**
     * 获取此时店铺最大id
     * @return
     */
    @GetMapping("/getMaxShopId")
    public int getMaxShopId() {
        return shopService.getMaxShopId();
    }

    /**
     * 更新店铺信息
     * @param map
     * @return
     */
    @PostMapping("/updateShop")
    public boolean updateShop(@RequestBody Map<String,Object> map){
//        commodityService.updateGood(updateGood);
//        return commodityService.getAllShopCommodity();
        System.out.println(map);
        System.out.println(shopService.updateShop(map));
        return shopService.updateShop(map);
    }

    /**
     * 删除店铺信息（更新店铺的删除标记）
     * @param map
     * @return
     */
    @PostMapping("/deleteShop")
    public boolean deleteShop(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return shopService.deleteShop(map);
    }

    /**
     * 插入店铺信息
     * @param map
     * @return
     */
    @PostMapping("/insertShop")
    public boolean insertShop(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return shopService.insertShop(map);
    }

    /**
     * 批量更新店铺此时的状态为正营业
     * @param list
     * @return
     */
    @PostMapping("/updateShopStatus0")
    public boolean updateShopStatus0(@RequestBody List<Object> list) {
//        for (int i = 0; i <= array.size(); i++) {
//            Map<String,Object> map = array[i];
//            return shopService.updateShopStstus0(map);
//        }
        System.out.println(list);
        return shopService.updateShopStatus0(list);

    }

    /**
     * 批量更新店铺状态为暂停营业
     * @param list
     * @return
     */
    @PostMapping("/updateShopStatus1")
    public boolean updateShopStatus1(@RequestBody List<Object> list) {
        System.out.println(list);
        return shopService.updateShopStatus1(list);

    }

    /**
     * 批量更新店铺状态为店铺关闭
     * @param list
     * @return
     */
    @PostMapping("/updateShopStatus2")
    public boolean updateShopStatus2(@RequestBody List<Object> list) {
        System.out.println(list);
        return shopService.updateShopStatus2(list);

    }

//    @PostMapping("/uploadImg")
//    public FileVisitResult upload(@RequestParam("pciture")MultipartFile picture, HttpServletRequest request) {
//        logger.info("您已进入图片上传服务")
//    }
}
