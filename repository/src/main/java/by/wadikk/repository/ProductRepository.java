package by.wadikk.repository;

import by.wadikk.repository.model.Product;

import java.util.List;


public interface ProductRepository {

    Product findById(Integer id);

    Product findByName(String productName);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    Boolean deleteById(Integer id);

    List<Product> getAll();
}
