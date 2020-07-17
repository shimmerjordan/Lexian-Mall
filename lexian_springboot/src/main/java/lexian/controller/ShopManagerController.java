package lexian.controller;

import lexian.entity.ShopManager;
import lexian.service.ShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 查询店铺管理员的个人信息
     * @param map
     * @return
     */
    @PostMapping("/searchShopManager")
    public List<ShopManager> searchShopManager(@RequestBody Map<String,Object> map){
//        System.out.println(map);
        List<ShopManager> result=shopManagerService.searchShopManager(map);
//        System.out.println(result);
        return result;
    }

    /**
     * 更新店铺管理员的个人信息
     * @param map
     * @return
     */
    @PostMapping("/updateShopManager")
    public boolean updateShopManager(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return shopManagerService.updateShopManager(map);
    }

    /**
     * 删除店铺管理员的个人信息，注销（更新其删除标记）
     * @param map
     * @return
     */
    @PostMapping("/deleteShopManager")
    public boolean deleteShopManager(@RequestBody Map<String,Object> map) {
        return shopManagerService.deleteShopManager(map);
    }
}
