/**
 * 
 */
package lexian.service;

import java.util.List;

import lexian.entity.Specs;

/**
 * @author yang990322
 *
 */
public interface SpecsService {

	List<Specs> listSpecs(String commodityId);
}
