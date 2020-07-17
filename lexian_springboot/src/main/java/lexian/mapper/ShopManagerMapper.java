package lexian.mapper;

import lexian.entity.ShopManager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ShopManagerMapper {
    /**
     * 查询符合条件的店铺管理员
     * @param map
     * @return
     */
    List<ShopManager> searchShopManager(Map<String,Object> map);

    /**
     * 更新店铺管理员信息
     * @param map
     * @return
     */
    int updateShopManager(Map<String,Object> map);

    /**
     * 删除店铺管理员4
     * @param map
     * @return
     */
    int deleteShopManager(Map<String,Object> map);
}