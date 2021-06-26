package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.Shop;
import by.wadikk.servicedelivery.model.User;

import java.util.List;

public interface ShopService {

    List<Shop> getAllShops();

    Shop getByName(String name);

    Boolean deleteShop(Integer id);

    Shop editShopById(Integer id, String name, String description);


}
