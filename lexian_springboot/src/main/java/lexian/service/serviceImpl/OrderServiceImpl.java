package lexian.service.serviceImpl;

import lexian.entity.JiuFenOrder;
import lexian.entity.Order;
import lexian.mapper.OrderMapper;
import lexian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;

    private String UTCToLocal(String UTC) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date temp=df.parse(UTC);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(temp);
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper){
        this.orderMapper=orderMapper;
    }

    @Override
    public List<Order> getAllOrder(Map<String,Object> map){
        return orderMapper.getAllOrder(map);
    }

    @Override
    public int[] getDateRange(int start, int end) {
        return orderMapper.getDateRange(start,end);
    }

    @Override
    public boolean addOrder(Map<String, Object> map) {
        try {
            map.put("timestamp",UTCToLocal((String)map.get("timestamp")));
            orderMapper.addOrder(map);
            int flag=orderMapper.addOrder_Item(map);
            return flag>0;
        }catch (ParseException e){
            return false;
        }
    }

    @Override
    public boolean updateOrder(Map<String, Object> map) {
        try {
            map.put("timestamp",UTCToLocal((String)map.get("timestamp")));
            orderMapper.updateOrder(map);
            int flag=orderMapper.updateOrder_Item(map);
            return flag>0;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Order> getUserOrder(String userID) {
        return orderMapper.getUserOrder(userID);
    }

    @Override
    public List<JiuFenOrder> getJiuFenOrder() {
        return orderMapper.getJiuFenOrder();
    }

    @Override
    public List<JiuFenOrder> getJiuFenOrderByID(Integer id) {
        return orderMapper.getJiuFenOrderByID(id);
    }

    @Override
    public boolean DeleteJiuFenOrder(Map<String, Object> map) {
        int flag=orderMapper.DeleteJiuFenOrder(map);
        return flag>1;
    }

    @Override
    public boolean UpdateJiuFenOrder(Map<String, Object> map) {
        int flag=orderMapper.UpdateJiuFenOrder(map);
        return flag>1;
    }
}
