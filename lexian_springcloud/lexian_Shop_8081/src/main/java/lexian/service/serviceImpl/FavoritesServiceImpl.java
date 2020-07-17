/**
 * 
 */
package lexian.service.serviceImpl;

import lexian.mapper.FavoritesMapper;
import lexian.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author yang990322
 *
 */
@Service
public class FavoritesServiceImpl implements FavoritesService {

	@Autowired
	FavoritesMapper favoritesMapper;

	@Override
	public Date getAddTime(String commodityId, String uid) {

		return favoritesMapper.selectFavoritesByCommodityIdAndUid(commodityId, uid);
	}

	@Override
	public Boolean save(Map<String, Object> favorites) {
		favorites.put("addtime", new Date());
		return favoritesMapper.insert(favorites) > 0;
	}

	@Override
	public Boolean deleteByCidAndUid(String commodityId, String uid) {

		return favoritesMapper.deleteByCidAndUid(commodityId, uid) > 0;
	}

}
