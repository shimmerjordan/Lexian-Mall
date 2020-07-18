package lexian.mapper;

import lexian.entity.JiuFenOrder;
import lexian.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {
    /**
     * 根据条件获取订单列表
     * @param map 搜索条件
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
     * @param m 新订单记录的信息
     */
    void addOrder(Map<String,Object> m);

    /**
     * 增加一条订单——商品记录
     * @param m
     * @return
     */
    int addOrder_Item(Map<String,Object> m);

    /**
     * 更新订单信息
     * @param m
     */
    void updateOrder(Map<String,Object> m);

    /**
     * 更新订单——商品联系表
     * @param m
     * @return
     */
    int updateOrder_Item(Map<String,Object> m);

    /**
     * 获取用户对应的订单信息
     * @param userID
     * @return
     */
    List<Order> getUserOrder(String userID);

    /**
     * 获取当前顾客条件对应的订单信息
     * @param map
     * @return
     */
    List<HashMap> getCustomerOrder(Map<String, Object> map);

    /**
     * 获取纠纷订单
     * @return
     */
    List<JiuFenOrder> getJiuFenOrder();

    /**
     * 根据ID获取纠纷订单
     * @param id
     * @return
     */
    List<JiuFenOrder> getJiuFenOrderByID(Integer id);

    /**
     * 删除纠纷订单
     * @param map
     * @return
     */
    int DeleteJiuFenOrder(Map<String,Object> map);

    /**
     * 更新纠纷订单
     * @param map
     * @return
     */
    int UpdateJiuFenOrder(Map<String,Object> map);

    /**
     * 删除一条订单记录
     * @param i
     * @return
     */
    int deleteOrder(int i);
}
