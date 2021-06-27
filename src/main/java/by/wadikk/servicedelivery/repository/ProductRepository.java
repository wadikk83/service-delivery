package by.wadikk.servicedelivery.repository;

import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.model.User;

import java.util.List;

public interface ProductRepository {

    Product findById(Integer id);

    Product findByName(String productName);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Boolean deleteById(Integer id);

    List<Product> getAll();
}
