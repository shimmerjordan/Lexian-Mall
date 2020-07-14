package lexian.service;

import lexian.entity.Activity;
import lexian.entity.Commodity;

import java.util.List;


public interface UniIndexService {
    List<Commodity> getIndexCommodity();

    List<Activity> getIndexActivity();

    List<Commodity> getIndexSearchCommodity(String name);
}
