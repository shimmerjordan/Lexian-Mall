package lexian.service.serviceImpl;

import lexian.entity.taobaoData;
import lexian.mapper.TaobaoMapper;
import lexian.service.TaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 淘宝爬虫相关的Service接口实现
 **/

@Service
public class TaobaoServiceImpl implements TaobaoService {
    private TaobaoMapper taobaoMapper;

    @Autowired
    public void setCommodityMapper(TaobaoMapper taobaoMapper) {
        this.taobaoMapper = taobaoMapper;
    }

    /**
     * 重写Service的获取淘宝爬虫商品的方法 调用mapper
     * @param name
     * @return
     */
    @Override
    public List<taobaoData> getAlltaobaoGoods(String name) {
        return taobaoMapper.getAlltaobaoGoods(name);
    }
}
