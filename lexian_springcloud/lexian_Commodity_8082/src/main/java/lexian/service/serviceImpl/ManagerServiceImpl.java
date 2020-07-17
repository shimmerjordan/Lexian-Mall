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

    @Override
    public List<List<Manager>> getAllRoleMember() {
        List<List<Manager>> res=new ArrayList<>();
        res.add(managerMapper.getRoleManagers(1));
        res.add(managerMapper.getRoleManagers(2));
        res.add(managerMapper.getRoleManagers(3));
        return res;
    }

    @Override
    public boolean addManager(Map<String,Object> m) {
        int res=managerMapper.addManager(m);
        return res>0;
    }

    @Override
    public boolean updateManager(Map<String, Object> m) {
        int res=managerMapper.updateManager(m);
        return  res>0;
    }

    @Override
    public boolean deleteManager(int index) {
        int res = managerMapper.deleteManager(index);
        return res>0;
    }
}
