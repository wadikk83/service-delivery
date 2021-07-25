package by.wadikk.service.service;

import by.wadikk.repository.model.Product;
import by.wadikk.repository.model.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> getAllShops();

    Shop getByName(String name);

    Shop getById(Integer id);

    Boolean deleteShop(Integer id);

    Shop editShopById(Integer id, String name, String description);

    Boolean editProductPriceAndAmountByShopId(Integer id, Product product, Integer amount, Integer price);

    Shop createShop(String name, String description);

    Shop sortedProductByPrice(Integer id);


}
