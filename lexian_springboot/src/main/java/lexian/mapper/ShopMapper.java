package lexian.mapper;


import lexian.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ShopMapper {
    /**
     * 获取全部店铺信息
     * @return
     */
    List<Shop> getAllShop();

    /**
     * 获取店铺最大id，对新增时的店铺id赋值
     * @return
     */
    int getMaxShopId();

    /**
     * 更新店铺信息
     * @param map
     * @return
     */
    int updateShop(Map<String,Object> map);

    /**
     * 删除店铺信息
     * @param map
     * @return
     */
    int deleteShop(Map<String,Object> map);

    /**
     * 通过条件对符合的店铺信息进行查询
     * @param map
     * @return
     */
    List<Shop> searchShopByInformation(Map<String,Object> map);

    /**
     * 插入店铺信息
     * @param map
     * @return
     */
    int insertShop(Map<String,Object> map);

    /**
     * 更新店铺状态（0为正营业，1为暂停营业，2为店铺关闭）
     * @param list
     * @return
     */
    int updateShopStatus0(List<Object> list);

    int updateShopStatus1(List<Object> list);

    int updateShopStatus2(List<Object> list);
}