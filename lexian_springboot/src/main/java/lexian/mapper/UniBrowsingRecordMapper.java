package lexian.mapper;

import lexian.entity.UniBrowsingRecord;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface UniBrowsingRecordMapper {

    List<UniBrowsingRecord> getHistory(String userID);
}
