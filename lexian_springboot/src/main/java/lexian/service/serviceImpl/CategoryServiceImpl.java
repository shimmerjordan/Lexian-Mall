/**
 * 
 */
package lexian.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import lexian.common.CacheStatic;
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
	RedisTemplate<String, String> redisTemplate;

	@Autowired
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	public List<Category> list() {
		Long xx = redisTemplate.opsForList().size(CacheStatic.categotyCache);
		List<Category> categoryList = new ArrayList<>();
		Long count = categoryMapper.countAll();
		if (xx == count) {
			List<String> lists = redisTemplate.opsForList().range(CacheStatic.categotyCache, 0, -1);
			return JSON.parseArray(lists.toString(), Category.class);
		}
		redisTemplate.delete(CacheStatic.categotyCache);
		categoryList = categoryMapper.selectAll();
		List<String> xxs = JSON.parseArray(JSON.toJSONString(categoryList), String.class);
		redisTemplate.opsForList().rightPushAll(CacheStatic.categotyCache, xxs);
		return categoryList;
	}

}
