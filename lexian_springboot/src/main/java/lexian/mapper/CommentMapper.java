/**
 * 
 */
package lexian.mapper;

import java.util.List;

import lexian.entity.Comment;

/**
 * @author yang990322
 *
 */
public interface CommentMapper {

	List<Comment> selectByCommodityId(String commodityId);

	Long countByCommodityId(String commodityId);
}
