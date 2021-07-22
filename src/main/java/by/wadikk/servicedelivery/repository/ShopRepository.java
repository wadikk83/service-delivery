package by.wadikk.servicedelivery.repository;

import by.wadikk.servicedelivery.model.Shop;

import java.util.List;


public interface ShopRepository {

    Shop findById(Integer id);

    Shop findByName(String shopName);

    Shop addShop(Shop shop);

    Shop updateShop(Shop shop);

    Boolean deleteById(Integer id);

    List<Shop> getAll();
}
