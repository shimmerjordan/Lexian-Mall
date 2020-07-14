package lexian.service.serviceImpl;

import lexian.entity.BrowsingRecord;
import lexian.mapper.BrowsingRecordMapper;
import lexian.service.UniUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UniUserServiceImpl implements UniUserService {
    private BrowsingRecordMapper browsingRecordMapper;
    @Autowired
    public void setCommodityMapper(BrowsingRecordMapper browsingRecordMapper) {
        this.browsingRecordMapper = browsingRecordMapper;
    }
    @Override
    public List<BrowsingRecord> getHistory(String userID) {
        return browsingRecordMapper.getHistory(userID);
    }
}
