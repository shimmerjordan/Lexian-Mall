/**
 * 
 */
package lexian.mapper;

import lexian.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yang990322
 *
 */
@Mapper
@Repository
public interface CategoryMapper {

	List<Category> selectAll();
	
}
