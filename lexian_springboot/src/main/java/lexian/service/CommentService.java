/**
 * 
 */
package lexian.service;

import java.util.List;

import lexian.entity.Comment;

/**
 * @author yang990322
 *
 */
public interface CommentService {

	List<Comment> listByCommodityId(String commodityId);
	
}
