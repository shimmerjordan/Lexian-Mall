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

    /**
     * 时间格式转换，UTC=>yyyy-MM-dd HH:mm:ss
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
    public void setOrderMapper(OrderMapper orderMapper){
        this.orderMapper=orderMapper;
    }

    /**
     * 根据条件获取所有订单
     * @param map
     * @return
     */
    @Override
    public List<Order> getAllOrder(Map<String,Object> map){
        return orderMapper.getAllOrder(map);
    }

    /**
     * 获取时间范围内订单数量信息
     * @param start 开始时间
     * @param end 结束时间
     * @return
     */
    @Override
    public int[] getDateRange(int start, int end) {
        return orderMapper.getDateRange(start,end);
    }

    /**
     * 增加一条新的订单记录
     * @param map 新订单记录的信息
     * @return
     */
    @Override
    public boolean addOrder(Map<String, Object> map) {
        try {
            map.put("date",UTCToLocal((String)map.get("date")));
            orderMapper.addOrder(map);
            int flag=orderMapper.addOrder_Item(map);
            return flag>0;
        }catch (ParseException e){
            return false;
        }
    }

    /**
     * 更新订单信息
     * @param map 更新信息
     * @return
     */
    @Override
    public boolean updateOrder(Map<String, Object> map) {
        try{
            map.put("date",UTCToLocal((String)map.get("date")));
            orderMapper.updateOrder(map);
            int flag=orderMapper.updateOrder_Item(map);
            return flag>0;
        }catch (Exception e){
            return  false;
        }
    }

    /**
     * 根据用户ID获取订单列表
     * @param userID
     * @return
     */
    @Override
    public List<Order> getUserOrder(String userID) {
        return orderMapper.getUserOrder(userID);
    }

    /**
     * 获取客户条件对应的订单列表
     * @param map
     * @return
     */
    @Override
    public List<HashMap> getCustomerOrder(Map<String, Object> map) {

        List<HashMap> temp0 = orderMapper.getCustomerOrder(map);
        List<HashMap> orderList = new ArrayList<>();
        for(int i = 0; i < temp0.size(); i++){
            HashMap<String, Object> flag0 = new HashMap<String, Object>();
            HashMap<String, Object> result = new HashMap<String, Object>();
            HashMap<String, Object> goodsMap = new HashMap<String, Object>();
            List<HashMap> goodList = new ArrayList<>();
            flag0 = temp0.get(i);

            result.put("time",flag0.get("date"));
            result.put("state",flag0.get("status"));
            result.put("state",flag0.get("status"));
            goodsMap.put("title",flag0.get("name"));
            goodsMap.put("price",flag0.get("price"));
            goodsMap.put("image",flag0.get("image"));
            goodsMap.put("number",flag0.get("commodity_quantity"));
            goodsMap.put("attr",flag0.get("specs_name"));
            goodList.add(goodsMap);
            result.put("goodList",goodList);
            orderList.add(result);

        }
        System.out.println(orderList);
        return orderList;
    }

    /**
     * 获取纠纷订单
     * @return
     */
    @Override
    public List<JiuFenOrder> getJiuFenOrder() {
        return orderMapper.getJiuFenOrder();
    }

    /**
     * 根据ID获取纠纷订单
     * @param id
     * @return
     */
    @Override
    public List<JiuFenOrder> getJiuFenOrderByID(Integer id) {
        return orderMapper.getJiuFenOrderByID(id);
    }

    /**
     * 删除纠纷订单
     * @param map 删除的订单的信息
     * @return
     */
    @Override
    public boolean DeleteJiuFenOrder(Map<String, Object> map) {
        int flag=orderMapper.DeleteJiuFenOrder(map);
        return flag>1;
    }

    /**
     * 更新纠纷订单
     * @param map
     * @return
     */
    @Override
    public boolean UpdateJiuFenOrder(Map<String, Object> map) {
        int flag=orderMapper.UpdateJiuFenOrder(map);
        return flag>1;
    }

    /**
     * 根据ID删除订单
     * @param i 被删除的订单记录ID
     * @return
     */
    @Override
    public boolean deleteOrder(int i) {
        int flag=orderMapper.deleteOrder(i);
        return flag>0;
    }
}
