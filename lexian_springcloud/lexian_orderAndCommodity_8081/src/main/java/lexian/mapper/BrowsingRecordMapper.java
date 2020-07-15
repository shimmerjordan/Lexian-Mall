/**
 * 
 */
package lexian.mapper;

import lexian.entity.BrowsingRecord;

import java.util.List;

/**
 * @author yang990322
 *
 */
public interface BrowsingRecordMapper {

	void insert(BrowsingRecord browsingRecord);
	List<BrowsingRecord> getHistory(String userID);

}
