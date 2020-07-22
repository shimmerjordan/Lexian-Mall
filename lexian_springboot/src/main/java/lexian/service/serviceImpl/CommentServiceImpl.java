/**
 * 
 */
package lexian.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import lexian.entity.Comment;
import lexian.mapper.CommentMapper;
import lexian.service.CommentService;

/**
 * @author yang990322
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper commentMapper;

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Override
	public List<Comment> listByCommodityId(String commodityId) {
		Long xx = redisTemplate.opsForList().size(commodityId);
		Long count = commentMapper.countByCommodityId(commodityId);
		if (xx == count) {
			List<String> lists = redisTemplate.opsForList().range(commodityId, 0, -1);
			return JSON.parseArray(lists.toString(), Comment.class);
		}
		redisTemplate.delete(commodityId);
		List<Comment> commentList = commentMapper.selectByCommodityId(commodityId);
		List<String> xxs = JSON.parseArray(JSON.toJSONString(commentList), String.class);
		redisTemplate.opsForList().rightPushAll(commodityId, xxs);
		return commentList;
	}

}
