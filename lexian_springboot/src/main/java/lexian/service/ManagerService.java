package lexian.service;

import lexian.entity.Manager;

import java.util.List;
import java.util.Map;

public interface ManagerService {
    List<List<Manager>> getAllRoleMember();
    boolean addManager(Map<String,Object> m);
    boolean updateManager(Map<String,Object> m);
}
