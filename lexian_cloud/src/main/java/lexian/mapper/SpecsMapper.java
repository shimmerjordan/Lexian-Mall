/**
 * 
 */
package lexian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lexian.entity.Specs;

/**
 * @author yang990322
 *
 */
public interface SpecsMapper {

	List<String> selectSpecsByCommodityId(String commodityId);

	List<Specs> selectSpecsInList(@Param("ids") List<String> ids);

}
