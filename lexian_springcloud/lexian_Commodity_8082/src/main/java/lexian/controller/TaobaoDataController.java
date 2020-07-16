package lexian.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lexian.entity.taobaoData;
import lexian.service.TaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaobaoDataController{
    private TaobaoService taobaoService;
    
    @Autowired
    public void setTaobaoService(TaobaoService taobaoService) {
        this.taobaoService = taobaoService;
    }

    @PostMapping("/api/getAlltaobaoGoods")
    public PageInfo<taobaoData> getAlltaobaoGoods(@RequestBody Map<String,Object> map){
        //这里是分页的内容 前端传的是listQuery 其中包含了page和 limit属性
        //page选中的页数  limit是一页多少个元素
        int pageNo = (int)map.get("page");
        int limit = (int)map.get("limit");
        String name = (String)map.get("name");
        if(name!="")
            name="%"+name+"%";
        else
            name=null;
        PageHelper.startPage(pageNo,limit);
        List<taobaoData> resultList;
        resultList = taobaoService.getAlltaobaoGoods(name);
        PageInfo<taobaoData> result = new PageInfo<>(resultList);
        System.out.print(result);
        return result;
    }

}
