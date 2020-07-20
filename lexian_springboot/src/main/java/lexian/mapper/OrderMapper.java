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
     * 移动端获取顾客订单
     * @param map 顾客信息
     * @return 订单列表
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

    /**
     * @note 取消订单接口，将取消的订单state设为9
     * @parameter  orderID
     * @note 接口cancelCustomerOrder
     */
    boolean cancelCustomerOrder(Map<String, Object> map);

    /**
     * @note 删除订单，将取消的订单的isDelete设为1
     * @parameter  orderID
     * @note 接口deleteCustomerOrder
     */
    boolean deleteCustomerOrder(Map<String, Object> map);

    /**
     * @note 用于根据订单查询店铺ID
     * @param map
     * @return int类型的店铺ID
     */
    int selectShopByOrder(Map<String, Object> map);

    /**
     * @note 客户端提交纠纷订单信息
     * @param map
     * @return 标识操作成功的boolean变量
     */
    boolean applyCustomerJiufenOrder(Map<String, Object> map);

    /**
     * @note 更新用户订单状态
     * @param map
     * @return 标识操作成功的boolean变量
     */
    boolean updateOrderState(Map<String, Object> map);

    boolean commentOrder(Map<String ,Object> map);
}
