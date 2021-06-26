package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductServiceImpl implements ProductService {

    private static ProductService productService;

    private List<Product> products = new ArrayList<Product>();

    private ProductServiceImpl() {


        /*products.add(new Product(1, "Product1", "Prod1-dsc1", "Prod1-dsc2"));
        products.add(new Product(2, "Product2", "Prod2-dsc1", "Prod2-dsc2"));
        products.add(new Product(3, "Product3", "Prod3-dsc1", "Prod3-dsc2"));
        products.add(new Product(4, "Product4", "Prod4-dsc1", "Prod4-dsc2"));
        log.info("Create product service with products" + products.toString());*/
    }

    public static ProductService getService() {
        if (productService == null) {
            productService = new ProductServiceImpl();
        }
        return productService;
    }

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

    @Override
    public Product getByName(String name) {
        return products.stream().filter(u -> u.equals(name)).findAny().orElse(null);
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        Product toBeDeleted = products.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeDeleted != null) {
            products.remove(toBeDeleted);
            log.info("Detele product " + toBeDeleted);
            return true;
        }
        log.info("Product with id " + id + " can't be deleted - product not found");
        return false;
    }

    @Override
    public Product editProductById(Integer id, String name, String description1, String description2) {
        if (id == null) {
            log.info("Edit product: id is null");
            return null;
        }
        Product toBeEdit = products.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeEdit != null) {
            log.info("Edit product " + toBeEdit);
            toBeEdit.setName(name);
            toBeEdit.setDescription1(description1);
            toBeEdit.setDescription2(description2);
            log.info("Product after edit " + toBeEdit);
            return toBeEdit;
        }
        log.info("Product with id " + id + " not found");
        return null;
    }

    @Override
    // TODO: 26.06.2021 Override method
    public Integer findProductByDescription(String... description) {
        return null;
    }
}
