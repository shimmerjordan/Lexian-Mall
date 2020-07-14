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


    @GetMapping("/init")
    public List<Commodity> getIndexCommodity() {
        return uniIndexService.getIndexCommodity();
    }


    @GetMapping("/getActivity")
    public List<Activity> IndexActivity() {
        return uniIndexService.getIndexActivity();
    }

    @PostMapping("/indexSearch")
    public List<Commodity> indexSearch(@RequestBody Map<String,Object> map){
        String name=(String)map.get("searchName");
        List<Commodity> resultList;
        if(name!=null){
            name="%"+name+"%";
            System.out.println(name);
            resultList = uniIndexService.getIndexSearchCommodity(name);
        }
        else {
            resultList = uniIndexService.getIndexCommodity();
        }
        System.out.print(resultList);
        return resultList;
    }



}