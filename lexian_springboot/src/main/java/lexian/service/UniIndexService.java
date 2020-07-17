package lexian.service;

import lexian.entity.Activity;
import lexian.entity.Commodity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface UniIndexService {
    List<Commodity> getIndexCommodity();

    List<Activity> getIndexActivity();

    List<Commodity> getIndexSearchCommodity(String name);

    List<Commodity> getSalesItem(String aID);
}
