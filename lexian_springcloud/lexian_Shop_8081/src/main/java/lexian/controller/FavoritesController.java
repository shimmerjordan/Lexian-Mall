/**
 * 
 */
package lexian.controller;

import lexian.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yang990322
 *
 */
@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {

	@Autowired
    FavoritesService favoritesService;

	@RequestMapping("/save")
	public Boolean save(@RequestBody Map<String, Object> favorites){
		
		return favoritesService.save(favorites);
	}
	
	@RequestMapping("/delete")
	public Boolean delete(Map<String,String> map){
		String commodityId = map.get("commodityId");
		String uid = map.get("uid");
		return favoritesService.deleteByCidAndUid(commodityId,uid);
	}
	
	
}
