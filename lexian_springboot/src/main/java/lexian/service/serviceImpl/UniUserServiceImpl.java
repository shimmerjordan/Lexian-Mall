package lexian.service.serviceImpl;

import lexian.entity.Commodity;
import lexian.entity.UniBrowsingRecord;
import lexian.mapper.CommodityMapper;
import lexian.mapper.FavoritesMapper;
import lexian.mapper.UniBrowsingRecordMapper;
import lexian.service.UniUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * UniApp用户中心相关的Service接口实现
 */
@Service
public class UniUserServiceImpl implements UniUserService {
    private CommodityMapper commodityMapper;
    private UniBrowsingRecordMapper uniBrowsingRecordMapper;
    private FavoritesMapper favoritesMapper;

    @Autowired
    public void setCommodityMapper(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }

    @Autowired
    public void setUniBrowsingRecordMapper(UniBrowsingRecordMapper uniBrowsingRecordMapper) {
        this.uniBrowsingRecordMapper = uniBrowsingRecordMapper;
    }
    @Autowired
    public void setFavoritesMapper(FavoritesMapper favoritesMapper) {
        this.favoritesMapper = favoritesMapper;
    }

    /**
     * 获取浏览历史方法重写
     * @param userID
     * @return
     */
    @Override
    public List<UniBrowsingRecord> getHistory(String userID) {
        return uniBrowsingRecordMapper.getHistory(userID);
    }
    /**
     * 获取商品收藏夹方法重写
     * @param userID
     * @return
     */
    @Override
    public List<Commodity> getFavorites(String userID) {
        return commodityMapper.getFavorites(userID);
    }
    /**
     * 取消收藏方法重写
     * @param map
     * @return
     */
    @Override
    public boolean cancelFavorite(Map<String, Object> map) {
        return favoritesMapper.cancelFavorite(map);
    }
}
