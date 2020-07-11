/**
 * 
 */
package lexian.mapper;

import java.util.List;

import lexian.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yang990322
 *
 */
@Mapper
@Repository
public interface CategoryMapper {

	List<Category> selectAll();
	
}
