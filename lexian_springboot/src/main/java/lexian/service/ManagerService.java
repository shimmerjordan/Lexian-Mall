package lexian.service;

import lexian.entity.Manager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface ManagerService {
    List<List<Manager>> getAllRoleMember();
    boolean addManager(Map<String,Object> m);
    boolean updateManager(Map<String,Object> m);
    boolean deleteManager(int index);
}
