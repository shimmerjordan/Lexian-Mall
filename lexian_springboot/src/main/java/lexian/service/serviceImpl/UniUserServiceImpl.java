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

    @Override
    public List<UniBrowsingRecord> getHistory(String userID) {
        return uniBrowsingRecordMapper.getHistory(userID);
    }

    @Override
    public List<Commodity> getFavorites(String userID) {
        return commodityMapper.getFavorites(userID);
    }
    @Override
    public boolean cancelFavorite(Map<String, Object> map) {
        return favoritesMapper.cancelFavorite(map);
    }
}
