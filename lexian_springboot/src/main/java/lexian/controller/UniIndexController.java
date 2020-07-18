package lexian.controller;

import lexian.entity.Activity;
import lexian.entity.Commodity;
import lexian.service.UniIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/uniIndex")
public class UniIndexController {
    private UniIndexService uniIndexService;

    @Autowired
    public void UniIndexService(UniIndexService uniIndexService) {
        this.uniIndexService = uniIndexService;
    }

    /**
     * 该方法是UniApp端的首页初始化，
     * 获取首页的商品数据
     * @return
     */
    @GetMapping("/init")
    public List<Commodity> getIndexCommodity() {
        return uniIndexService.getIndexCommodity();
    }


    /**
     * 该方法是UniApp端的首页活动获取，
     * 获取首页的活动信息
     * @return
     */
    @GetMapping("/getActivity")
    public List<Activity> IndexActivity() {
        return uniIndexService.getIndexActivity();
    }

    /**
     * 该方法是UniApp端的首页活动获取，
     * 获取首页的活动信息
     * @param map
     * @return
     */
    @PostMapping("/indexSearch")
    public List<Commodity> indexSearch(@RequestBody Map<String,Object> map){
        //获取前端传递的搜索信息参数-商品名称
        String name=(String)map.get("searchName");
        List<Commodity> resultList;
        //如果用户输入的商品名称不为空则执行搜索
        //若用户未输入数据则搜索所有商品
        if(name!=null){
            //此处进行包装 方便后续sql语句执行模糊查询
            name="%"+name+"%";
            System.out.println(name);
            resultList = uniIndexService.getIndexSearchCommodity(name);
        }
        else {
            //未输入数据则返回所有的商品数据
            resultList = uniIndexService.getIndexCommodity();
        }
        System.out.print(resultList);
        return resultList;
    }


    /**
     * 该方法用于获取UniApp端的首页活动的对应活动商品数据，
     * @param map
     * @return
     */
    @PostMapping("/getSalesItem")
    public List<Commodity> getSalesItem (@RequestBody Map<String,Object> map){
        //获取首页的推广活动编号信息
        String aID=(String)map.get("aID");
        //通过活动编号取得对应的促销商品信息，便于前端页面跳转
        return uniIndexService.getSalesItem(aID);
    }


}