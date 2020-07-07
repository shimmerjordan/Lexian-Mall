package lexian.mapper;


import lexian.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

 @Mapper
 @Repository
public interface ShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    List<Shop> getAllShop();

    int getMaxShopId();

//    List<Shop> updateShop(Shop record);
}