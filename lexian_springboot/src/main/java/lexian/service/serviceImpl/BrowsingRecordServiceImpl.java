/**
 * 
 */
package lexian.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lexian.entity.BrowsingRecord;
import lexian.mapper.BrowsingRecordMapper;
import lexian.service.BrowsingRecordService;

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
