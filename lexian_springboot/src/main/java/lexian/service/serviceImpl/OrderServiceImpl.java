package lexian.service.serviceImpl;

import lexian.entity.JiuFenOrder;
import lexian.entity.Order;
import lexian.mapper.OrderMapper;
import lexian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
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
            map.put("date",UTCToLocal((String)map.get("date")));
            orderMapper.addOrder(map);
            int flag=orderMapper.addOrder_Item(map);
            return flag>0;
        }catch (ParseException e){
            return false;
        }
    }

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

    @Override
    public List<Order> getUserOrder(String userID) {
        return orderMapper.getUserOrder(userID);
    }

    /**
     * 移动端获取顾客订单
     * @param map 顾客信息
     * @return 订单列表
     */
    @Override
    public List<HashMap> getCustomerOrder(Map<String, Object> map) {
        //Mapper返回的List类型数据（List内为HashMap）
        List<HashMap> temp0 = orderMapper.getCustomerOrder(map);
        List<HashMap> orderList = new ArrayList<>();
        for(int i = 0; i < temp0.size(); i++){
            //用于存储List单个元素的HashMap
            HashMap<String, Object> flag0 = new HashMap<String, Object>();
            HashMap<String, Object> result = new HashMap<String, Object>();
            //结果List中的每个订单对应的goodsMap
            HashMap<String, Object> goodsMap = new HashMap<String, Object>();

            //最终返回前端的结果List
            List<HashMap> goodList = new ArrayList<>();

            //取Mapper返回的List中第i个HashMap数据
            flag0 = temp0.get(i);

            //将数据库中的timestamp类型数据转化为String类型返回到前台
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String tsStr = "";
            tsStr = sdf.format(flag0.get("date"));
            result.put("time",tsStr);

            //逐个将flag0中值存放入对应HashMap中
            result.put("state",flag0.get("status"));
            result.put("orderID",flag0.get("ID"));
            goodsMap.put("title",flag0.get("name"));
            goodsMap.put("price",flag0.get("price"));
            goodsMap.put("image",flag0.get("image"));
            goodsMap.put("number",flag0.get("commodity_quantity"));
            goodsMap.put("attr",flag0.get("specs_name"));
            goodList.add(goodsMap);
            result.put("goodList",goodList);

            //因为前端接收数据类型需要为List这里添加到List中返回
            orderList.add(result);
        }
        System.out.println(orderList);
        return orderList;
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

    @Override
    public boolean deleteOrder(int i) {
        int flag=orderMapper.deleteOrder(i);
        return flag>0;
    }

    /**
     * @note 取消订单接口，将取消的订单state设为9
     * @parameter orderID
     */
    @Override
    public boolean cancelCustomerOrder(Map<String, Object> map){
        return orderMapper.cancelCustomerOrder(map);
    }

    /**
     * @note 删除订单，将取消的订单的isDelete设为1
     * @parameter  orderID
     */
    @Override
    public boolean deleteCustomerOrder(Map<String, Object> map){
        return orderMapper.deleteCustomerOrder(map);
    }
}
