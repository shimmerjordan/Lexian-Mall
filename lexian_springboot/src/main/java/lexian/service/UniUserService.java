package lexian.service;

import lexian.entity.UniBrowsingRecord;

import java.util.List;

public interface UniUserService {

    List<UniBrowsingRecord> getHistory(String userID);

}
