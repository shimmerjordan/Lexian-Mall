package lexian.controller;

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

    @PostMapping("/getHistory")
    public List<UniBrowsingRecord> getUserHistory(@RequestBody Map<String,Object> map) {
        String userID= (String) map.get("userID");
        return uniUserService.getHistory(userID);
    }
}
