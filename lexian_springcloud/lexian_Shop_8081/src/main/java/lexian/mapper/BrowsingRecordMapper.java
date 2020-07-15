/**
 * 
 */
package lexian.mapper;

import lexian.entity.BrowsingRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yang990322
 *
 */
@Repository
@Mapper
public interface BrowsingRecordMapper {

	void insert(BrowsingRecord browsingRecord);


}
