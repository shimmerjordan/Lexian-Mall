/**
 * 
 */
package lexian.service;

import lexian.entity.Specs;

import java.util.List;

/**
 * @author yang990322
 *
 */
public interface SpecsService {

	List<Specs> listSpecs(String commodityId);
}
