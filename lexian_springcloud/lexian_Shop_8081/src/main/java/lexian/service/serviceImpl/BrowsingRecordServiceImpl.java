/**
 * 
 */
package lexian.service.serviceImpl;

import lexian.entity.BrowsingRecord;
import lexian.mapper.BrowsingRecordMapper;
import lexian.service.BrowsingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yang990322
 *
 */
@Service
public class BrowsingRecordServiceImpl implements BrowsingRecordService {

	@Autowired
	BrowsingRecordMapper browsingRecordMapper;
	
	@Override
	public void save(BrowsingRecord browsingRecord) {
		browsingRecordMapper.insert(browsingRecord);
		
	}

}
