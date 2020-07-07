/**
 * 
 */
package lexian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lexian.entity.Category;
import lexian.service.CategoryService;

/**
 * @author yang990322
 *
 */
@RestController
@RequestMapping("api/category/")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/list")
	public List<Category> list() {
		return categoryService.list();
	}
}
