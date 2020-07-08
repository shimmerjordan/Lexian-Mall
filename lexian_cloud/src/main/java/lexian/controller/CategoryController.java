/**
 * 
 */
package lexian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Commodity> listByCommodityId(String commodityId) {
		return commodityService.listCommodityByCommodityId(commodityId);
	}
}
