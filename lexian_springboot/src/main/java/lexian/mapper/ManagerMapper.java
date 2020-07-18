package lexian.mapper;

import lexian.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ManagerMapper {
    /**
     * 获取当前类型的系统管理员列表
     * @param i
     * @return
     */
    List<Manager> getRoleManagers(int i);

    /**
     * 增加一名管理员
     * @param m 新增管理员信息
     * @return
     */
    int addManager(Map<String,Object> m);

    /**
     * 更新管理员信息
     * @param m
     * @return
     */
    int updateManager(Map<String,Object> m);

    /**
     * 删除一条管理员记录
     * @param index
     * @return
     */
    int deleteManager(int index);
}
