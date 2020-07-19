package lexian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.Category;
import lexian.entity.Commodity;
import lexian.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.Oneway;
import java.util.List;
import java.util.Map;

@RestController
public class ShopCommodityController {
    private CommodityService commodityService;

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    /**
     * 该方法是获取商品信息列表
     * @param map
     * @return
     */
    @PostMapping("/api/shop/goodsInfo")
    public PageInfo<Commodity> getAllShopCommodity(@RequestBody Map<String,Object> map) {
        //这里是分页的内容 前端传的是listQuery 其中包含了page(页码)和 limit（每页多少条数据）属性
        //page选中的页数  limit是一页多少个元素
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        PageHelper.startPage(pageNo,limit);
        List<Commodity> resultList;
        //这里是用于模糊查询 前端名字的输入框内容也包含在listQuery中的name属性
        //判断是否输入了搜索的名字，名字不为空就调用名字去查询
        //为空就直接查所有商品
        String name=(String)map.get("name");
        if(name!=null){
            //这里包装成sql语句 例如 '%香香鸡%' 直接包装好 sql语句直接Like #{name}即可
            name="%"+name+"%";
            System.out.println(name);
            resultList = commodityService.getAllShopCommodityByName(name);
        }
        else {
            //如果没有输入名字进行模糊查询 则查询所有的商品数据
            resultList = commodityService.getAllShopCommodity();
        }

        //对查询的数据进行分页操作
        PageInfo<Commodity> result = new PageInfo<>(resultList);
        System.out.print(result);
        return result;
    }

    /**
     * 该方法是更新后台修改的商品信息
     * @param map
     * @return
     */
    @PostMapping("/api/shop/updateGood")
    public boolean updateGood(@RequestBody Map<String, Object> map) {

        System.out.println(map);
        /*
          前端传过来的商品数据利用map去接收
          接收到后去更新数据库的商品数据
         */
        System.out.println(commodityService.updateGood(map));
        //更新成功返回true 失败返回false
        return commodityService.updateGood(map);
    }

    /**
     * 后台管理员删除对应的商品
     * @param map
     * @return
     */
    @PostMapping("/api/shop/deleteGood")
    public boolean deleteGood(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        return commodityService.deleteGood(map);
    }

    /**
     * 添加商品
     * @param map
     * @return
     */
    @PostMapping("/api/shop/addGood")
    public boolean addGood(@RequestBody Map<String,Object> map){
        int sta = (int)map.get("specification");
        System.out.println("2222222222222222222"+sta);
        if(sta==0){
            String s = "件";
            map.put("specification",s);
        }
        else{
            String s = "条";
            map.put("specification",s);
        }
        System.out.println(map);
        return commodityService.addGood(map);
    }

    /**
     * 获取所有的商品类别
     * @return
     */
    @PostMapping("/api/shop/getAllCategory")
    public List<Category> getAllCategory(){
        //返回数据类型为查询的所有数据 List
        List<Category> result = commodityService.getAllCategory();
        System.out.println(result);
        return result;
    }

    @PostMapping("/api/shop/getAllCommodityByCategory")
    public PageInfo<Commodity> getAllCommodityByCategory(@RequestBody Map<String,Object> map){
        System.out.println(map);
        //这里是分页的内容 前端传的是listQuery 其中包含了page(页码)和 limit（每页多少条数据）属性
        //page选中的页数  limit是一页多少个元素
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        //模糊查询
        String name=(String)map.get("name");
        //这里包装成sql语句 例如 '%香香鸡%' 直接包装好 sql语句直接Like #{name}即可
        name="%"+name+"%";
        map.put("name",name);
        System.out.println(name);
        PageHelper.startPage(pageNo,limit);
        List<Commodity> resultList;
        //对查询的数据进行分页操作
        resultList=commodityService.getAllCommodityByCategory(map);
        PageInfo<Commodity> result = new PageInfo<>(resultList);
        System.out.print(result);
        return result;
    }

}

