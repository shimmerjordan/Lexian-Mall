package lexian.service.serviceImpl;

import lexian.entity.UniBrowsingRecord;
import lexian.mapper.UniBrowsingRecordMapper;
import lexian.service.UniUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniUserServiceImpl implements UniUserService {

    private UniBrowsingRecordMapper uniBrowsingRecordMapper;
    @Autowired
    public void setUniBrowsingRecordMapper(UniBrowsingRecordMapper uniBrowsingRecordMapper) {
        this.uniBrowsingRecordMapper = uniBrowsingRecordMapper;
    }
    @Override
    public List<UniBrowsingRecord> getHistory(String userID) {
        return uniBrowsingRecordMapper.getHistory(userID);
    }
}
