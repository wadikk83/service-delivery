package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.service.CategoryService;
import by.wadikk.servicedelivery.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ProductServiceImpl implements ProductService {

    private static ProductService productService;

    private CategoryService categoryService = new CategoryServiceImpl().getService();

    private List<Product> products = new ArrayList<Product>();

    ProductServiceImpl() {

        Set<String> description1 = new HashSet<>();
        description1.add("Prod1-dsc1");
        description1.add("Prod1-dsc2");
        description1.add("Prod1-dsc3");
        Set<Category> category1 = new HashSet<>();
        category1.add(categoryService.getCategoryByName(categoryService.getRootCategory(), "Root"));
        products.add(new Product(1, "Product1", description1, category1));

        Set<String> description2 = new HashSet<>();
        description2.add("Prod2-dsc1");
        description2.add("Prod2-dsc2");
        description2.add("Prod2-dsc3");
        Set<Category> category2 = new HashSet<>();
        category1.add(categoryService.getCategoryByName(categoryService.getRootCategory(), "Root"));
        products.add(new Product(2, "Product2", description2, category2));

        Set<String> description3 = new HashSet<>();
        description3.add("Prod3-dsc1");
        description3.add("Prod3-dsc2");
        description3.add("Prod3-dsc3");
        Set<Category> category3 = new HashSet<>();
        category3.add(categoryService.getCategoryByName(categoryService.getRootCategory(), "Root"));
        products.add(new Product(3, "Product3", description3, category3));

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
    public Product editProductById(Integer id, String name, String... description) {
        if (id == null) {
            log.info("Edit product: id is null");
            return null;
        }
        Product toBeEdit = products.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeEdit != null) {
            log.info("Edit product " + toBeEdit);
            toBeEdit.setName(name);
            toBeEdit.getDescription().clear();
            for (String descr : description) {
                toBeEdit.getDescription().add(descr);
            }
            log.info("Product after edit " + toBeEdit);
            return toBeEdit;
        }
        log.info("Product with id " + id + " not found");
        return null;
    }

    @Override
    // TODO: 26.06.2021 Override method
    public List<Product> findProductByDescription(String... description) {
        List<Product> resultList = new ArrayList<>();
        for (Product product : products) {
            Boolean equalsDescription = true;
            for (String descr : description)
                if (!product.getDescription().contains(descr)) {
                    equalsDescription = false;
                }
            if (equalsDescription) resultList.add(product);
        }
        return resultList;
    }
}
