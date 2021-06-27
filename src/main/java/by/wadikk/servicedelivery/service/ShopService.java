package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.model.Shop;
import by.wadikk.servicedelivery.model.User;

import java.util.List;

public interface ShopService {

    List<Shop> getAllShops();

    Shop getByName(String name);

    Shop getById(Integer id);

    Boolean deleteShop(Integer id);

    Shop editShopById(Integer id, String name, String description);

    Boolean editProductPrice(Integer id, Product product, Integer price);

    Boolean editProductAmount(Integer id, Product product, Integer amount);

}
