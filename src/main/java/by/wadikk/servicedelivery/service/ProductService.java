package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.model.Shop;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Product getByName(String name);

    Boolean deleteProduct(Integer id);

    Product editProductById(Integer id, String name, String ...description);

    List<Product> findProductByDescription(String ...description);


}
