/**
 * 
 */
package lexian.service;

import lexian.entity.Comment;

import java.util.List;

/**
 * @author yang990322
 *
 */
public interface CommentService {

	List<Comment> listByCommodityId(String commodityId);
	
}
