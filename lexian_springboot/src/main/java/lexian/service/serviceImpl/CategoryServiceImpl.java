/**
 * 
 */
package lexian.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
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
		String xx = redisTemplate.opsForList().index(CacheStatic.categotyCache, -1);
		List<Category> categoryList = new ArrayList<>();
		if (StringUtils.isNotBlank(xx)) {
			List<String> lists = redisTemplate.opsForList().range(CacheStatic.categotyCache, 0, -1);
			for (String obj : lists) {
				categoryList.add(JSON.parseObject(obj, Category.class));
			}
			return categoryList;
		}
		System.out.println("1");
		categoryList = categoryMapper.selectAll();
		List<String> xxs = JSON.parseArray(JSON.toJSONString(categoryList), String.class);
		redisTemplate.opsForList().rightPushAll(CacheStatic.categotyCache, xxs);
		return categoryList;
	}
	
	public void updateCache(){
		redisTemplate.opsForList().rightPop(CacheStatic.categotyCache,1,TimeUnit.SECONDS);

	}

}
