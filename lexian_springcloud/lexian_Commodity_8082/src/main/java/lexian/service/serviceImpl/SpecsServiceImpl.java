/**
 * 
 */
package lexian.service.serviceImpl;

import lexian.entity.Specs;
import lexian.mapper.SpecsMapper;
import lexian.service.SpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang990322
 *
 */
@Service
public class SpecsServiceImpl implements SpecsService {

	@Autowired
	SpecsMapper specsMapper;

	public List<Specs> listSpecs(String commodityId) {
		List<String> ids = specsMapper.selectSpecsByCommodityId(commodityId);
		if (null != ids && ids.size() > 0) {
			return specsMapper.selectSpecsInList(ids);
		}
		return null;
	}

}
