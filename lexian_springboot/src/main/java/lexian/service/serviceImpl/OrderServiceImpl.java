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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
            goodsMap.put("commodityID", flag0.get("commodity_id"));
            goodsMap.put("attr",flag0.get("specs_name"));
            goodList.add(goodsMap);
            result.put("goodList",goodList);

            //因为前端接收数据类型需要为List这里添加到List中返回
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

    /**
     * @param map
     * @return
     */
    @Override
    public boolean applyCustomerJiufenOrder(Map<String, Object> map) {

        //同时判断更新订单状态和工单提交情况是否操作成功
        boolean flag;
        boolean modifyOrderState;
        //把前端传过来的map中的orderID取出来
        Object orderID = map.get("orderID");
        //存在一个临时的HashMap中传给selecthopOrder(HashMap)
        HashMap<String, Object> temp0 = new HashMap<>();
        temp0.put("status", map.get("orderState"));
        temp0.put("orderID", orderID);
        temp0.put("commodityID",map.get("commodityID"));
        //通过selectShopOrder(HashMap)提出订单商品对应的店铺
        System.out.println("commodityID"+map.get("commodityID"));
        System.out.println("temp0="+temp0);
        System.out.println("map="+map);
        Object shopID = (Object)orderMapper.selectShopByOrder(temp0);


        //存入原始传入的map中
        map.put("shopID", shopID);
        System.out.println("map="+map);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        map.put("applyTime", formatter.format(date));

        boolean result = orderMapper.applyCustomerJiufenOrder(map);
        if(result){
            modifyOrderState = orderMapper.updateOrderState(temp0);
            flag = modifyOrderState && result;
            return flag;
        }else{
            return false;
        }
    }

    @Override
    public boolean modifyCustomerOrderState(Map<String, Object> map) {
        return orderMapper.updateOrderState(map);
    }

    @Override
    public boolean commentOrder(Map<String, Object> map){
        //获取当前时间为comment_time
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        map.put("comment_time", formatter.format(date));

        boolean result = orderMapper.commentOrder(map);
        return result;
    }
}
