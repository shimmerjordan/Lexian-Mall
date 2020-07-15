/**
 * 
 */
package lexian.mapper;

import lexian.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yang990322
 *
 */
@Repository
@Mapper
public interface CommentMapper {

	List<Comment> selectByCommodityId(String commodityId);

}
