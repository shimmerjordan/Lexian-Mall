/**
 * 
 */
package lexian.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lexian.entity.Category;
import lexian.mapper.CategoryMapper;
import lexian.service.CategoryService;

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
