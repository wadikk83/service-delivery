package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.repository.ProductRepository;
import by.wadikk.servicedelivery.repository.impl.ProductRepositoryImpl;
import by.wadikk.servicedelivery.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepositoryImpl().getService();

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        return productRepository.deleteById(id);
    }

    @Override
    public Product editProductDescriptionById(Integer id, String name, String... description) {
        if (id == null) {
            log.info("Edit product: id is null");
            return null;
        }
        Product toBeEdit = productRepository.findById(id);
        if (toBeEdit != null) {
            log.info("Edit product " + toBeEdit);
            toBeEdit.setName(name);
            toBeEdit.getDescription().clear();
            for (String descr : description) {
                toBeEdit.getDescription().add(descr);
            }
            log.info("Product after edit " + toBeEdit);
            return productRepository.updateProduct(toBeEdit);
        }
        log.info("Product with id " + id + " not found");
        return null;
    }

    @Override
    public Product editProductCategoryById(Integer id, String name, Category... categories) {
        if (id == null) {
            log.info("Edit product: id is null");
            return null;
        }
        Product toBeEdit = productRepository.findById(id);
        if (toBeEdit != null) {
            log.info("Edit product " + toBeEdit);
            toBeEdit.setName(name);
            toBeEdit.getCategories().clear();
            for (Category cat : categories) {
                toBeEdit.getCategories().add(cat);
            }
            log.info("Product after edit " + toBeEdit);
            return productRepository.updateProduct(toBeEdit);
        }
        log.info("Product with id " + id + " not found");
        return null;
    }

    @Override
    public List<Product> findProductByDescription(String... description) {
        List<Product> resultList = new ArrayList<>();
        for (Product product : getAllProduct()) {
            Boolean equalsDescription = true;
            for (String descr : description)
                if (!product.getDescription().contains(descr)) {
                    equalsDescription = false;
                }
            if (equalsDescription) resultList.add(product);
        }
        return resultList;
    }

    @Override
    public List<Product> findProductByCategory(Category... categories) {
        List<Product> resultList = new ArrayList<>();
        for (Product product : getAllProduct()) {
            Boolean equalsDescription = true;
            for (Category cat : categories)
                if (!product.getCategories().contains(cat)) {
                    equalsDescription = false;
                }
            if (equalsDescription) resultList.add(product);
        }
        return resultList;
    }

    @Override
    public Product addNewProduct(String name, Set<String> description, Set<Category> categories) {
        Product product = new Product(name, description, categories);
        return productRepository.addProduct(product);
    }
}
