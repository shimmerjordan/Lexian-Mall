package lexian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.Category;
import lexian.entity.Commodity;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/api/shop/goodsInfo")
    public PageInfo<Commodity> getAllShopCommodity(@RequestBody Map<String,Object> map) {
        //这里是分页的内容 前端传的是listQuery 其中包含了page和 limit属性
        //page选中的页数  limit是一页多少个元素
        int pageNo = Integer.parseInt(String.valueOf(map.get("page")));
        int limit = Integer.parseInt(String.valueOf(map.get("limit")));
        PageHelper.startPage(pageNo,limit);
        List<Commodity> resultList;
        //这里是用于模糊查询 前端名字的输入框内容也包含在listQuery中的name属性
        //判断是否输入了搜索的名字，名字不为空就调用名字去查询
        //为空就直接查所有商品
        String name=(String)map.get("name");
        if(name!=null){
            //这里包装成sql语句 例如 '%香香鸡%' 直接包装好 sql语句直接#{name}即可
            name="%"+name+"%";
            System.out.println(name);
            resultList = commodityService.getAllShopCommodityByName(name);
        }
        else {
            resultList = commodityService.getAllShopCommodity();
        }
        PageInfo<Commodity> result = new PageInfo<Commodity>(resultList);
        System.out.print(result);
        return result;
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

