package lexian.controller;

import lexian.entity.Manager;
import lexian.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    private ManagerService managerService;

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/all-role")
    public List<List<Manager>> getAllRole(){
        return managerService.getAllRoleMember();
    }

    @PostMapping("/add")
    public boolean addManager(@RequestBody Map<String,Object> m){
        return managerService.addManager(m);
    }

    @PostMapping("/update")
    public boolean updateManager(@RequestBody Map<String,Object> m){
        return managerService.updateManager(m);
    }

    @GetMapping("/delete")
    public boolean deleteManager(@RequestParam int index){
        return managerService.deleteManager(index);
    }
}
