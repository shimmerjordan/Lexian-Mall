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

    /**
     * 获取当前系统中各类角色的列表
     * @return 三类系统管理员对应的list
     */
    @GetMapping("/all-role")
    public List<List<Manager>> getAllRole(){
        return managerService.getAllRoleMember();
    }

    /**
     * 增加一个系统管理员
     * @param m 系统管理员对应的信息
     * @return
     */
    @PostMapping("/add")
    public boolean addManager(@RequestBody Map<String,Object> m){
        return managerService.addManager(m);
    }

    /**
     * 更新系统管理员对应信息
     * @param m 更新后的系统管理员对应信息
     * @return 更新是否成功
     */
    @PostMapping("/update")
    public boolean updateManager(@RequestBody Map<String,Object> m){
        return managerService.updateManager(m);
    }

    /**
     * 删除管理员
     * @param index 被删除的管理员的ID
     * @return 删除是否成功
     */
    @GetMapping("/delete")
    public boolean deleteManager(@RequestParam int index){
        return managerService.deleteManager(index);
    }
}
