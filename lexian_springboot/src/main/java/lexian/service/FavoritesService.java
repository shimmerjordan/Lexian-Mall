/**
 * 
 */
package lexian.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * @author yang990322
 *
 */
@Transactional
public interface FavoritesService {

	Date getAddTime(String commodityId,String uid);

	Boolean save(Map<String, Object> favorites);

	Boolean deleteByCidAndUid(String commodityId, String uid);
}
