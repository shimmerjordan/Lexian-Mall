/**
 * 
 */
package lexian.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public List<Comment> listByCommodityId(String commodityId) {

		return commentMapper.selectByCommodityId(commodityId);
	}

}
