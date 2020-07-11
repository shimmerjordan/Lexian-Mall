package lexian.mapper;

import lexian.entity.ShopManager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ShopManagerMapper {
    List<ShopManager> searchShopManager(Map<String,Object> map);
}