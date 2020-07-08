package lexian.mapper;

import lexian.entity.Commodity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommodityMapper {
    List<Commodity> getAllShopCommodity();
    int updateGood(Map<String,Object> map);
<<<<<<< HEAD
    int deleteGood(Map<String,Object> map);
=======
    
    List<Commodity> selectCommodityByCommodityId(String commodityId);
    
    int deleteGood(Integer id);
>>>>>>> 96370e8061cf29b7a93dd2bcba624e85caa4816d
}
