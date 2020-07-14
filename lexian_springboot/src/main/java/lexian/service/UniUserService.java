package lexian.service;

import lexian.entity.BrowsingRecord;

import java.util.List;

public interface UniUserService {
    List<BrowsingRecord> getHistory(String userID);
}
