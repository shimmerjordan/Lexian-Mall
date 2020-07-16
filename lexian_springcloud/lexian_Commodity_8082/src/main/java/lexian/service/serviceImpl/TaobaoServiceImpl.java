package lexian.service.serviceImpl;

import lexian.entity.taobaoData;
import lexian.mapper.TaobaoMapper;
import lexian.service.TaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaobaoServiceImpl implements TaobaoService {
    private TaobaoMapper taobaoMapper;

    @Autowired
    public void setCommodityMapper(TaobaoMapper taobaoMapper) {
        this.taobaoMapper = taobaoMapper;
    }
    @Override
    public List<taobaoData> getAlltaobaoGoods(String name) {
        return taobaoMapper.getAlltaobaoGoods(name);
    }
}
