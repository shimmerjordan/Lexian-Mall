package lexian.controller;

import lexian.entity.Activity;
import lexian.entity.Commodity;
import lexian.service.UniIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


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
}