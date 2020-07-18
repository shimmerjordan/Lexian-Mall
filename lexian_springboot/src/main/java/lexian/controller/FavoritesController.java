/**
 * 
 */
package lexian.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lexian.service.FavoritesService;

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
	public Boolean delete(String commodityId, String uid){
		return favoritesService.deleteByCidAndUid(commodityId,uid);
	}
	
	
}
