package lexian.mapper;

import lexian.entity.Commodity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommodityMapper {
<<<<<<< HEAD
    List<Commodity> getAllShopCommodity();
    int updateGood(Map<String,Object> map);
    int deleteGood(Map<String,Object> map);
    List<Commodity> selectCommodityByCommodityId(String commodityId);
    int deleteGood(Integer id);
=======
	List<Commodity> getAllShopCommodity();

	int updateGood(Map<String, Object> map);

	int deleteGood(Map<String, Object> map);

	List<Commodity> selectCommodityByCategoryId(Commodity commodity);

	int addGood(Map<String, Object> map);

>>>>>>> 01729adcad0723208a59d29dccc68edde3f776aa
}
