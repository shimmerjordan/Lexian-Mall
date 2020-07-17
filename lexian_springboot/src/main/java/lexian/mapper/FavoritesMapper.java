package lexian.mapper;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author yang990322
 *
 */
@Mapper
@Repository
public interface FavoritesMapper {

	Date selectFavoritesByCommodityIdAndUid(@Param("commodityId") String commodityId, @Param("uid") String uid);

	int insert(Map<String, Object> favorites);

	int deleteByCidAndUid(@Param("commodityId") String commodityId, @Param("uid") String uid);

	boolean cancelFavorite(Map<String, Object> map);

}
