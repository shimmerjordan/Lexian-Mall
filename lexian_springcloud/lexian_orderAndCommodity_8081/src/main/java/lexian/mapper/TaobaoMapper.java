package lexian.mapper;

import lexian.entity.taobaoData;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaobaoMapper {
    List<taobaoData> getAlltaobaoGoods(String name);
}
