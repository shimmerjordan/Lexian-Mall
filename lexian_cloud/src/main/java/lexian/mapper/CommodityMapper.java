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
    int deleteGood(Map<String,Object> map);

    List<Commodity> selectCommodityByCommodityId(String commodityId);
<<<<<<< .merge_file_a11348
    List<Commodity> getIndexCommodity();
=======
    int deleteGood(Integer id);
	List<Commodity> selectCommodityByCategoryId(Commodity commodity);

	int addGood(Map<String, Object> map);

>>>>>>> .merge_file_a26072
}
