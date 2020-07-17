/**
 * 
 */
package lexian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang990322
 *
 */
@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {

	private RestTemplate restTemplate;
	private static final String REST_PREFIX="http://lexian-zuul/lexian-shop-provider/api/favorites";

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping("/save")
	public Boolean save(@RequestBody Map<String, Object> favorites){
		return restTemplate.postForObject(REST_PREFIX+"/save",favorites,Boolean.class);
	}
	
	@RequestMapping("/delete")
	public Boolean delete(String commodityId, String uid){
		Map<String,String> map=new HashMap<>();
		map.put("commodityId",commodityId);
		map.put("uid",uid);
		return restTemplate.postForObject(REST_PREFIX+"/delete",map,Boolean.class);
	}
	
	
}
