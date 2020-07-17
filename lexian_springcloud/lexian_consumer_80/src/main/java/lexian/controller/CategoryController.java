/**
 * 
 */
package lexian.controller;

import com.github.pagehelper.PageInfo;
import lexian.entity.BrowsingRecord;
import lexian.entity.Category;
import lexian.entity.Commodity;
import lexian.entity.model.GoodDetailsModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yang990322
 *
 */
@RestController
@RequestMapping("api/category/")
public class CategoryController {
	private RestTemplate restTemplate;
	private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider/api/category";

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	@RequestMapping("/list")
	public List<Category> list() {
		return restTemplate.getForObject(REST_PREFIX+"/list",List.class);
	}

	@RequestMapping("/listByCommodityId")
	public PageInfo<Commodity> listByCommodityId(@RequestBody Commodity commodity) {
		return restTemplate.postForObject(REST_PREFIX+"/listByCommodityId",commodity,PageInfo.class);
	}

	@RequestMapping("/getCommodity")
	public Commodity getCommodity(String commodityId, String uid) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("commodityId",commodityId);
		map.put("uid",uid);
		return restTemplate.postForObject(REST_PREFIX+"/getCommodity",map,Commodity.class);
	}

	@RequestMapping("/payment")
	public Map<String, Object> payment(@RequestBody GoodDetailsModel goodDetailsModel) {
		return restTemplate.postForObject(REST_PREFIX+"/payment",goodDetailsModel,Map.class);
	}
}
