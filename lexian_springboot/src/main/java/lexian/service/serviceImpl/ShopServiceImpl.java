package lexian.service.serviceImpl;

import lexian.entity.Shop;
import lexian.mapper.ShopMapper;
import lexian.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import  java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Service
public class ShopServiceImpl implements ShopService{
    private ShopMapper shopMapper;

    /**
     * 转换时间格式
     * @param UTC
     * @return
     * @throws ParseException
     */
    private String UTCToLocal(String UTC) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date temp=df.parse(UTC);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(temp);
    }
    @Autowired
    public void setShopMapper(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    @Override
    public List<Shop> getAllShop() {
        return shopMapper.getAllShop();
    }

    @Override
    public int getMaxShopId() {
        return shopMapper.getMaxShopId();
    }

    @Override
    public boolean updateShop(Map<String,Object> map) {
        int flag = shopMapper.updateShop(map);
        return flag > 0;
    }

    @Override
    public boolean deleteShop(Map<String,Object> map) {
        int flag = shopMapper.deleteShop(map);
        return flag>0;
    }

//    public boolean updateShopStstus0(Map<String,Object> map) {
//        int flag = shopMapper.updateShopStstus0(map);
//        return flag>0;
//    }

    @Override
    public List<Shop> searchShopByInformation(Map<String,Object> map) {
//        return shopMapper.searchShopByInformation(map);
        try {
            String beginTime = (String) map.get("beginTime");//赋值
            String endTime = (String) map.get("endTime");

            if(beginTime != null && endTime != null) { //对时间段进行查询，必须满足开始、结束时间同时输入
                map.put("beginTime",UTCToLocal((String)map.get("beginTime")));
                map.put("endTime",UTCToLocal((String)map.get("endTime")));
            }
            System.out.println(map);
            return shopMapper.searchShopByInformation(map);
        }catch (ParseException e) {
            return null;
        }
    }

    @Override
    public boolean insertShop(Map<String, Object> map) {
        int flag = shopMapper.insertShop(map);
        return flag > 0;
    }

    @Override
    public boolean updateShopStatus0(List<Object> list) {
        int flag = shopMapper.updateShopStatus0(list);
        return flag >0;
    }

    @Override
    public boolean updateShopStatus1(List<Object> list) {
        int flag = shopMapper.updateShopStatus1(list);
        return flag >0;
    }

    @Override
    public boolean updateShopStatus2(List<Object> list) {
        int flag = shopMapper.updateShopStatus2(list);
        return flag >0;
    }
}
