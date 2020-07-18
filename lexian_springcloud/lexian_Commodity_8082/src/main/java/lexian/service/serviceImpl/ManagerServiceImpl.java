package lexian.service.serviceImpl;

import lexian.entity.Manager;
import lexian.mapper.ManagerMapper;
import lexian.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService {

    private ManagerMapper managerMapper;

    @Autowired
    public void setManagerMapper(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    /**
     * 获取三种系统角色类型对应的系统管理员
     * @return
     */
    @Override
    public List<List<Manager>> getAllRoleMember() {
        List<List<Manager>> res=new ArrayList<>();
        res.add(managerMapper.getRoleManagers(1));
        res.add(managerMapper.getRoleManagers(2));
        res.add(managerMapper.getRoleManagers(3));
        return res;
    }

    /**
     * 增加一条管理员记录
     * @param m
     * @return
     */
    @Override
    public boolean addManager(Map<String,Object> m) {
        int res=managerMapper.addManager(m);
        return res>0;
    }

    /**
     * 更新系统管理员的信息
     * @param m
     * @return
     */
    @Override
    public boolean updateManager(Map<String, Object> m) {
        int res=managerMapper.updateManager(m);
        return  res>0;
    }

    /**
     * 删除一条系统管理员记录
     * @param index
     * @return
     */
    @Override
    public boolean deleteManager(int index) {
        int res = managerMapper.deleteManager(index);
        return res>0;
    }
}
