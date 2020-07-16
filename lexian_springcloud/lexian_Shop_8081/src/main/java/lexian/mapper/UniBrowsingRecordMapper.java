package lexian.mapper;

import lexian.entity.UniBrowsingRecord;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UniBrowsingRecordMapper {
    List<UniBrowsingRecord> getHistory(String userID);
}
