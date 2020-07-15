package lexian.mapper;

import lexian.entity.JiuFenOrder;
import lexian.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {
    List<Order> getAllOrder(Map<String,Object> map);
    int[] getDateRange(int start, int end);
    void addOrder(Map<String,Object> m);
    int addOrder_Item(Map<String,Object> m);
    void updateOrder(Map<String,Object> m);
    int updateOrder_Item(Map<String,Object> m);
    List<Order> getUserOrder(String userID);
    List<JiuFenOrder> getJiuFenOrder();
    List<JiuFenOrder> getJiuFenOrderByID(Integer id);
    int DeleteJiuFenOrder(Map<String,Object> map);
    int UpdateJiuFenOrder(Map<String,Object> map);
    int deleteOrder(int i);
}
