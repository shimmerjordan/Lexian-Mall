package lexian.mapper;


import lexian.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ShopMapper {
    List<Shop> getAllShop();

    int getMaxShopId();

    int updateShop(Map<String,Object> map);

    int deleteShop(Map<String,Object> map);

    int updateShopStstus0(Object select[]);

    List<Shop> searchShopByInformation(Map<String,Object> map);

    int insertShop(Map<String,Object> map);

    int updateShopStatus0(List<Object> list);

    int updateShopStatus1(List<Object> list);

    int updateShopStatus2(List<Object> list);
}