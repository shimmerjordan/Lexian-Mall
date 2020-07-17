package lexian.service.serviceImpl;

import lexian.entity.ShopManager;
import lexian.mapper.ShopManagerMapper;
import lexian.service.ShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Service
public class ShopManagerServiceImpl implements ShopManagerService{
    private ShopManagerMapper shopManagerMapper;

    private String UTCToLocal(String UTC) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date temp=df.parse(UTC);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(temp);
    }
    @Autowired
    public void setShopManagerMapper(ShopManagerMapper shopManagerMapper){
        this.shopManagerMapper = shopManagerMapper;
    }

    @Override
    public List<ShopManager> searchShopManager(Map<String,Object> map){
        return shopManagerMapper.searchShopManager(map);
    }

    @Override
    public boolean updateShopManager(Map<String ,Object> map){
        try {
            map.put("birthday",UTCToLocal((String)map.get("birthday")));//更新信息时，对用户选择的生日格式进行转换
            System.out.println(map);
            int flag = shopManagerMapper.updateShopManager(map);
            return flag > 0;
        }catch (ParseException e){
            return false;
        }
    }

    @Override
    public boolean deleteShopManager(Map<String ,Object> map) {
        int flag = shopManagerMapper.deleteShopManager(map);
        return flag > 0;
    }
}
