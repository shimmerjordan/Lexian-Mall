package lexian.mapper;

import lexian.entity.ActivityShop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Mapper
@Repository
public interface ActivityShopMapper {
    int insertActivityShop(Map<String,Object> map);
}
