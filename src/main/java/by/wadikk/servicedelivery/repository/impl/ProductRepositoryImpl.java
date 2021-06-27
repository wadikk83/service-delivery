package by.wadikk.servicedelivery.repository.impl;

import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.repository.ProductRepository;
import by.wadikk.servicedelivery.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    private static ProductRepository productRepository;

    private List<Product> products = new ArrayList<Product>();

    private static Integer idCount = 1;

    public ProductRepositoryImpl() {
    }

    //singleton
    public static ProductRepository getService() {
        if (productRepository == null) {
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }


    @Override
    public Product findById(Integer id) {
        return products.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Product findByName(String productName) {
        return products.stream()
                .filter(u -> u.getName().equals(productName))
                .findAny()
                .orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        product.setId(idCount++);
        products.add(product);
        log.info("Add new product ->" + product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        for (Product pr : products) {
            if (pr.getId().equals(product.getId()) || pr.getName().equals(product.getName())) {
                pr.setDescription(product.getDescription());
                pr.setCategories(product.getCategories());
                log.info("Update product with id -> " + pr.getId() + " and name->" + pr.getName());
                return pr;
            }
        }
        log.info("Can't update product with id -> " + product.getId() + " and name->" + product.getName());
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        Product toBeDeleted = findById(id);
        if (toBeDeleted != null) {
            products.remove(toBeDeleted);
            log.info("Detele product " + toBeDeleted);
            return true;
        }
        log.info("User with id " + id + " can't be deleted - user not found");
        return false;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
