/**
 * 
 */
package lexian.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import lexian.entity.BrowsingRecord;
import lexian.entity.Category;
import lexian.entity.Commodity;
import lexian.service.BrowsingRecordService;
import lexian.service.CategoryService;
import lexian.service.CommentService;
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

	@Autowired
	BrowsingRecordService browsingRecordService;
	
	@Autowired
	CommentService commentService;

	@RequestMapping("/list")
	public List<Category> list() {
		return categoryService.list();
	}

	@RequestMapping("/listByCommodityId")
	public PageInfo<Commodity> listByCommodityId(@RequestBody Commodity commodity) {
		return commodityService.listCommodityByCategoryId(commodity);
	}

	@RequestMapping("/getCommodity")
	public Commodity getCommodity(String commodityId, String uid) {
		Commodity commodity = commodityService.getCommodity(commodityId);
		commodity.setCommentList(commentService.listByCommodityId(commodityId));
		if (StringUtils.isNotBlank(uid)) {
			BrowsingRecord browsingRecord = new BrowsingRecord();
			browsingRecord.setBrowsingTime(new Date());
			browsingRecord.setCommodityId(Integer.parseInt(commodityId));
			browsingRecord.setCustomerId(Integer.parseInt(uid));
			browsingRecord.setDate(new Date());
			browsingRecord.setIsDelete(0);
			browsingRecordService.save(browsingRecord);
		}
		return commodity;
	}
}
