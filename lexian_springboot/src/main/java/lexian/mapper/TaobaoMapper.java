package lexian.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import lexian.entity.taobaoData;

@Mapper
@Repository
public interface TaobaoMapper {
    List<taobaoData> getAlltaobaoGoods(String name);
}
