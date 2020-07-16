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
    List<Manager> getRoleManagers(int i);

    int addManager(Map<String,Object> m);

    int updateManager(Map<String,Object> m);

    int deleteManager(int index);
}
