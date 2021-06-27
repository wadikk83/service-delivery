package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProduct();

    Product getByName(String name);

    Product getById(Integer id);

    Boolean deleteProduct(Integer id);

    Product editProductDescriptionById(Integer id, String name, String... description);

    Product editProductCategoryById(Integer id, String name, Category... categories);

    List<Product> findProductByDescription(String... description);

    List<Product> findProductByCategory(Category... categories);

    Product addNewProduct(String name, Set<String> description, Set<Category> categories);


}
