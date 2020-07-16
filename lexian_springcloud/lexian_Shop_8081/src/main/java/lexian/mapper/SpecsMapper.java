/**
 * 
 */
package lexian.mapper;

import lexian.entity.Specs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yang990322
 *
 */
@Mapper
@Repository
public interface SpecsMapper {

	List<String> selectSpecsByCommodityId(String commodityId);

	List<Specs> selectSpecsInList(@Param("ids") List<String> ids);

}
