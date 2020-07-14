package lexian.service;

import java.util.List;
import lexian.entity.taobaoData;

public interface TaobaoService {
    List<taobaoData> getAlltaobaoGoods(String name);
}
