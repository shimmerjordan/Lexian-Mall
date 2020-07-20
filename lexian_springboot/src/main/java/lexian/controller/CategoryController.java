/**
 * 
 */
package lexian.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import lexian.entity.BrowsingRecord;
import lexian.entity.Category;
import lexian.entity.Commodity;
import lexian.entity.model.GoodDetailsModel;
import lexian.service.AddressService;
import lexian.service.BrowsingRecordService;
import lexian.service.CartService;
import lexian.service.CategoryService;
import lexian.service.CommentService;
import lexian.service.CommodityService;
import lexian.service.CouponService;
import lexian.service.FavoritesService;
import lexian.service.SpecsService;

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

	@Autowired
	SpecsService specsService;

	@Autowired
	CouponService couponService;

	@Autowired
	AddressService addressService;

	@Autowired
	FavoritesService favoritesService;

	@Autowired
	CartService cartService;

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
		commodity.setSpecsList(specsService.listSpecs(commodityId));
		commodity.setCouponList(couponService.listConpon(uid));
		commodity.setAddtime(favoritesService.getAddTime(commodityId, uid));
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

	@RequestMapping("/payment")
	public Map<String, Object> payment(@RequestBody GoodDetailsModel goodDetailsModel) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> commoditys = new ArrayList<>();
		if (StringUtils.isNotBlank(goodDetailsModel.getCommodityId())) {
			Commodity commodity = commodityService.getCommodity(goodDetailsModel.getCommodityId());
			Map<String, Object> map = new HashMap<>();
			List<Commodity> list = new ArrayList<>();
			list.add(commodity);
			map.put("shopId", commodity.getShopId());
			map.put("shopName", commodity.getShopName());
			map.put("shopImg", commodity.getShopImg());
			map.put("goodCount", commodity.getGoodCount());
			map.put("list", list);
			commoditys.add(map);
		} else {
			List<Commodity> commodityList = cartService.listByCartIds(goodDetailsModel.getCartIds());
			Map<String, List<Commodity>> mapl = commodityList.stream()
					.collect(Collectors.groupingBy(Commodity::getShopId));
			for (String key : mapl.keySet()) {
				Map<String, Object> map = new HashMap<>();
				Commodity commodity = mapl.get(key).get(0);
				map.put("shopId", commodity.getShopId());
				map.put("shopName", commodity.getShopName());
				map.put("shopImg", commodity.getShopImg());
				map.put("goodCount", commodity.getGoodCount());
				map.put("list", mapl.get(key));
				commoditys.add(map);
			}

		}
		result.put("couponList", couponService.listConpon(goodDetailsModel.getUid()));
		result.put("addressList", addressService.listByCustomerId(goodDetailsModel.getUid()));
		result.put("commoditys", commoditys);
		return result;
	}
}
