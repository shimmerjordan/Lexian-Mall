package lexian.service;

import java.util.List;
import lexian.entity.taobaoData;
import org.springframework.transaction.annotation.Transactional;

/**
 * 淘宝爬虫商品相关的Service
 */
<<<<<<< HEAD

=======
>>>>>>> 9dfc9bec9445b1f0c9b271e7fdca19765ae3035e
@Transactional
public interface TaobaoService {
    /**
     * 获取淘宝的爬虫数据（参数name为空时）
     * 也可根据名字模糊查询
     * @param name
     * @return
     */
    List<taobaoData> getAlltaobaoGoods(String name);
}
