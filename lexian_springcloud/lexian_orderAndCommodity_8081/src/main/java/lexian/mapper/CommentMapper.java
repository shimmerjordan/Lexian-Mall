/**
 * 
 */
package lexian.mapper;

import lexian.entity.Comment;

import java.util.List;

/**
 * @author yang990322
 *
 */
public interface CommentMapper {

	List<Comment> selectByCommodityId(String commodityId);

}
