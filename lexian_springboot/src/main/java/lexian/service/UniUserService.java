package lexian.service;

import lexian.entity.Commodity;
import lexian.entity.UniBrowsingRecord;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UniUserService {

    List<UniBrowsingRecord> getHistory(String userID);
    List<Commodity> getFavorites(String userID);

}
