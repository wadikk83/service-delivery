package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.repository.ProductRepository;
import by.wadikk.servicedelivery.repository.impl.ProductRepositoryImpl;
import by.wadikk.servicedelivery.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

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
        // TODO: 17.07.2021 Rewrite this method

        /*if (id == null) {
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
        log.info("Product with id " + id + " not found");*/
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
        // TODO: 17.07.2021 Rewrite this method
        /*List<Product> resultList = new ArrayList<>();
        for (Product product : getAllProduct()) {
            Boolean equalsDescription = true;
            for (String descr : description)
                if (!product.getDescription().contains(descr)) {
                    equalsDescription = false;
                }
            if (equalsDescription) resultList.add(product);
        }
        return resultList;*/
        return null;
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
        // TODO: 17.07.2021 Rewrite this method
        /*Product product = new Product(name, description, categories);
        return productRepository.addProduct(product);*/
        return null;
    }
}
