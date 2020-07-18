package lexian.controller;

import lexian.entity.Commodity;
import lexian.entity.UniBrowsingRecord;
import lexian.service.UniUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/uniUser")
public class UniUserController {
    private UniUserService uniUserService;

    @Autowired
    public void UniUserService(UniUserService uniUserService) {
        this.uniUserService = uniUserService;
    }

    /**
     * 该方法是获取用户商品浏览记录
     * @param map
     * @return
     */
    @PostMapping("/getHistory")
    public List<UniBrowsingRecord> getUserHistory(@RequestBody Map<String,Object> map) {
        String userID= (String) map.get("userID");
//        接受前端传递的用户编号信息
//        并从数据库中获取该用户的浏览记录
        return uniUserService.getHistory(userID);
    }

    /**
     * 该方法是获取用户商品收藏夹
     * @param map
     * @return
     */

    @PostMapping("/getFavorites")
    public List<Commodity> getUserFavorites(@RequestBody Map<String,Object> map) {
        String userID= (String) map.get("userID");
//        接受前端传递的用户编号信息
//        并从数据库中获取该用户的商品收藏夹

        return uniUserService.getFavorites(userID);
    }

    /**
     * 该方法是获取用户商品收藏夹
     * @param map
     * @return
     */

    @PostMapping("/cancelFavorite")
    public boolean cancelFavorite(@RequestBody Map<String, Object> map) {
//        接受前端传递的参数
//        参数包括了用户编号信息以及所选择的商品ID的列表（List<commodityID>）
//        并更新数据库，完成逻辑删除操作
        boolean result = uniUserService.cancelFavorite(map);
        System.out.println(map);
        return result;
//        返回操作结果
    }
}
