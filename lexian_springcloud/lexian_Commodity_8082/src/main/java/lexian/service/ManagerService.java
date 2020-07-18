package lexian.service;

import lexian.entity.Manager;

import java.util.List;
import java.util.Map;

public interface ManagerService {
    /**
     * 获取角色对应的成员列表
     * @return
     */
    List<List<Manager>> getAllRoleMember();

    /**
     * 增加一名系统管理员
     * @param m
     * @return
     */
    boolean addManager(Map<String,Object> m);

    /**
     * 更新一条管理员记录
     * @param m
     * @return
     */
    boolean updateManager(Map<String,Object> m);

    /**
     * 删除一名管理员
     * @param index
     * @return
     */
    boolean deleteManager(int index);
}
