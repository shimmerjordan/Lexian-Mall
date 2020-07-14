package lexian.controller;

import lexian.entity.BrowsingRecord;
import lexian.entity.Commodity;
import lexian.service.UniIndexService;
import lexian.service.UniUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uniUser")
public class UniUserController implements UniUserService {
    private UniUserService uniUserService;

    @Autowired
    public void UniUserService(UniUserService uniUserService) {
        this.uniUserService = uniUserService;
    }

    @GetMapping("/getHistory")
    public List<BrowsingRecord> getHistory(String userID) {
        return uniUserService.getHistory(userID);
    }
}
