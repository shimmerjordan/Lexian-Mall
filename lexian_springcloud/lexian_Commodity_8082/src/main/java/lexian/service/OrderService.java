package lexian.service;

import lexian.entity.JiuFenOrder;
import lexian.entity.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderService {
    /**
     *根据条件搜索订单
     * @param map
     * @return
     */
    List<Order> getAllOrder(Map<String,Object> map);
    /**
     * 获取时间范围内的订单数量
     * @param start 开始时间
     * @param end 结束时间
     * @return
     */
    int[] getDateRange(int start, int end);

    /**
     * 向数据库新增一条订单记录
     * @param map 新订单记录的信息
     */
    boolean addOrder(Map<String,Object> map);

    /**
     * 更新订单
     * @param map 更新信息
     * @return
     */
    boolean updateOrder(Map<String,Object> map);

    /**
     * 根据userID获取订单
     * @param userID
     * @return
     */
    List<Order> getUserOrder(String userID);

    /**
     * 根据customer的条件获取订单列表
     * @param map
     * @return hashmap存储
     */
    List<HashMap> getCustomerOrder(Map<String, Object> map);

    /**
     * 获取纠纷订单
     * @return
     */
    List<JiuFenOrder> getJiuFenOrder();

    /**
     * 通过ID获取纠纷订单
     * @param id
     * @return
     */
    List<JiuFenOrder> getJiuFenOrderByID(Integer id);

    /**
     * 删除纠纷订单
     * @param map 删除的订单的信息
     * @return
     */
    boolean DeleteJiuFenOrder(Map<String,Object> map);

    /**
     * 更新纠纷订单
     * @param map
     * @return
     */
    boolean UpdateJiuFenOrder(Map<String,Object> map);

    /**
     * 删除订单记录
     * @param i 被删除的订单记录ID
     * @return
     */
    boolean deleteOrder(int i);
}
