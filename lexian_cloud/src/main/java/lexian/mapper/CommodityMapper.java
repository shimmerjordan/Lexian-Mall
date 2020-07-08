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
    
    List<Commodity> selectCommodityByCommodityId(String commodityId);
=======
    int deleteGood(Integer id);
>>>>>>> 122c06bec5b91ce7f9e6cd31ce6e172106c86c08
}
