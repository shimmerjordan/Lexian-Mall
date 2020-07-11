package lexian.service.serviceImpl;

import lexian.entity.Manager;
import lexian.mapper.ManagerMapper;
import lexian.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
        return res;
    }
}
