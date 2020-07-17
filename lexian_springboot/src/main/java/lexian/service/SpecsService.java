/**
 * 
 */
package lexian.service;

import java.util.List;

import lexian.entity.Specs;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yang990322
 *
 */
@Transactional
public interface SpecsService {

	List<Specs> listSpecs(String commodityId);
}
