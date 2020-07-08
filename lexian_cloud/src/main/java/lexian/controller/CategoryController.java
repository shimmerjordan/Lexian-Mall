/**
 * 
 */
package lexian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import lexian.entity.Category;
import lexian.entity.Commodity;
import lexian.service.CategoryService;
import lexian.service.CommodityService;

/**
 * @author yang990322
 *
 */
@RestController
@RequestMapping("api/category/")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	CommodityService commodityService;

	@RequestMapping("/list")
	public List<Category> list() {
		return categoryService.list();
	}

	@RequestMapping("/listByCommodityId")
	public PageInfo<Commodity> listByCommodityId(@RequestBody Commodity commodity) {
		return commodityService.listCommodityByCategoryId(commodity);
	}
}
