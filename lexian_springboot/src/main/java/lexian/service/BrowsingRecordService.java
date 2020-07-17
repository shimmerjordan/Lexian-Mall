/**
 * 
 */
package lexian.service;

import lexian.entity.BrowsingRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yang990322
 *
 */
@Transactional
public interface BrowsingRecordService {

	 void save(BrowsingRecord browsingRecord);
	
}
