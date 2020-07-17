/**
 * 
 */
package lexian.service.serviceImpl;

import lexian.entity.Category;
import lexian.mapper.CategoryMapper;
import lexian.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang990322
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryMapper categoryMapper;

	@Autowired
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	public List<Category> list() {

		return categoryMapper.selectAll();
	}

}
