package lexian.mapper;

import lexian.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerMapper {
    List<Manager> getRoleManagers(int i);
}
