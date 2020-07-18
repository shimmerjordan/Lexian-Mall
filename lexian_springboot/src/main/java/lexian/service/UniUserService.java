package lexian.service;

import lexian.entity.Commodity;
import lexian.entity.UniBrowsingRecord;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface UniUserService {
    List<UniBrowsingRecord> getHistory(String userID);
    List<Commodity> getFavorites(String userID);
    boolean cancelFavorite(Map<String, Object> map);
}
