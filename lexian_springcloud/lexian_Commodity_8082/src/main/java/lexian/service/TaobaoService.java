package lexian.service;

import lexian.entity.taobaoData;

import java.util.List;

public interface TaobaoService {
    List<taobaoData> getAlltaobaoGoods(String name);
}
