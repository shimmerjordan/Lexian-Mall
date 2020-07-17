package lexian.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.service.TaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lexian.entity.taobaoData;

import java.util.List;
import java.util.Map;

@RestController
public class TaobaoDataController{
    private TaobaoService taobaoService;
    
    @Autowired
    public void setTaobaoService(TaobaoService taobaoService) {
        this.taobaoService = taobaoService;
    }

    /**
     * 获取数据库中所有淘宝爬虫的商品数据
     * @param map
     * @return
     */
    @PostMapping("/api/getAlltaobaoGoods")
    public PageInfo<taobaoData> getAlltaobaoGoods(@RequestBody Map<String,Object> map){
        //这里是分页的内容 前端传的是listQuery 其中包含了page和 limit属性
        //page选中的页数  limit是一页多少个元素
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        String name = (String)map.get("name");
        //主要是进行模糊查询的处理操作
        //如果查询的名字不为空 则处理为“%名字%”格式  sql语句直接Like #{name}即可
        if(name!="")
            name="%"+name+"%";
        else
            name=null;
        PageHelper.startPage(pageNo,limit);
        //调用查询数据方法
        List<taobaoData> resultList;
        resultList = taobaoService.getAlltaobaoGoods(name);
        //查询的数据进行分页操作
        PageInfo<taobaoData> result = new PageInfo<>(resultList);
        System.out.print(result);
        return result;
    }

}
