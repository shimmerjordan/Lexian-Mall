package lexian.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

/**
 * 
 * @author yang990322
 *
 */
public interface FavoritesMapper {

	Date selectFavoritesByCommodityIdAndUid(@Param("commodityId") String commodityId, @Param("uid") String uid);

	int insert(Map<String, Object> favorites);

	int deleteByCidAndUid(@Param("commodityId") String commodityId, @Param("uid") String uid);

}
