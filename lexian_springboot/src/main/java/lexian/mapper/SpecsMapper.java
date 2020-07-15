/**
 * 
 */
package lexian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import lexian.entity.Specs;
import org.springframework.stereotype.Repository;

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
