package lexian.service;

import lexian.entity.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAllShop();

    int getMaxShopId();

//    List<Shop> updateShop(Shop record);
}