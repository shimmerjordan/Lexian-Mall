package lexian.service;

import lexian.entity.Commodity;
import lexian.entity.UniBrowsingRecord;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * UniApp用户中心相关的Service
 */
@Transactional
public interface UniUserService {
    /**
     * 根据用户ID获取浏览历史
     * @param userID
     * @return
     */
    List<UniBrowsingRecord> getHistory(String userID);
    /**
     * 根据用户ID获取商品收藏夹
     * @param userID
     * @return
     */
    List<Commodity> getFavorites(String userID);
    /**
     * 根据用户ID以及所选收藏夹商品的ID的List进行取消收藏
     * @param map
     * @return
     */
    boolean cancelFavorite(Map<String, Object> map);
}
