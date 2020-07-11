package lexian.mapper;

import lexian.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {
    List<Order> getAllOrder();
    int[] getDateRange(int start, int end);
    void addOrder(Map<String,Object> m);
    int addOrder_Item(Map<String,Object> m);
    void updateOrder(Map<String,Object> m);
    int updateOrder_Item(Map<String,Object> m);
    List<Order> getUserOrder(String userID);
}
