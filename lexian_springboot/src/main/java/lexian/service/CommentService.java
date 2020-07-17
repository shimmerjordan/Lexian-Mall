/**
 * 
 */
package lexian.service;

import java.util.List;

import lexian.entity.Comment;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yang990322
 *
 */
@Transactional
public interface CommentService {

	List<Comment> listByCommodityId(String commodityId);
	
}
