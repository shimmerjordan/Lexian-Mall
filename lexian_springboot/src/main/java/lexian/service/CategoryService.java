/**
 * 
 */
package lexian.service;

import java.util.List;

import lexian.entity.Category;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yang990322
 *
 */
@Transactional
public interface CategoryService {

	List<Category> list();
	
}
