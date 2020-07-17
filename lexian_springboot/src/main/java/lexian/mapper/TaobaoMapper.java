package lexian.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import lexian.entity.taobaoData;

@Mapper
@Repository
public interface TaobaoMapper {
    /**
     * 查询所有的淘宝爬取商品数据（name为空时）
     * 也可以根据名字查询指定（模糊查询 sql写Like）
     * @param name
     * @return
     */
    List<taobaoData> getAlltaobaoGoods(String name);
}
