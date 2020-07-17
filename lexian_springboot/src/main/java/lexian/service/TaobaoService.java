package lexian.service;

import java.util.List;
import lexian.entity.taobaoData;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TaobaoService {
    List<taobaoData> getAlltaobaoGoods(String name);
}
