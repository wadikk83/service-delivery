package by.wadikk.servicedelivery.todelete;

import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class ProductServiceImplOld  {

    private static ProductService productService;

    //private CategoryServiceOld categoryService = new CategoryServiceImplOld().getService();

    private List<Product> products = new ArrayList<Product>();

    private static Integer idCount = 1;

    ProductServiceImplOld() {
    }

    //singleton
    public static ProductService getService() {
        if (productService == null) {
            //productService = new ProductServiceImplOld();
        }
        return productService;
    }


    public List<Product> getAllProduct() {
        return products;
    }


    public Product getByName(String name) {
        return products.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElse(null);
    }


    public Product getById(Integer id) {

        return products.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }


    public Boolean deleteProduct(Integer id) {
        Product toBeDeleted = products.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeDeleted != null) {
            products.remove(toBeDeleted);
            log.info("Detele product " + toBeDeleted);
            return true;
        }
        log.info("Product with id " + id + " can't be deleted -> product not found");
        return false;
    }


    public Product editProductDescriptionById(Integer id, String name, String... description) {
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


    public Product editProductCategoryById(Integer id, String name, Category... categories) {
        if (id == null) {
            log.info("Edit product: id is null");
            return null;
        }
        Product toBeEdit = products.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeEdit != null) {
            log.info("Edit product " + toBeEdit);
            toBeEdit.setName(name);
            toBeEdit.getCategories().clear();
            for (Category cat : categories) {
                toBeEdit.getCategories().add(cat);
            }
            log.info("Product after edit " + toBeEdit);
            return toBeEdit;
        }
        log.info("Product with id " + id + " not found");
        return null;
    }


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


    public List<Product> findProductByCategory(Category... categories) {
        List<Product> resultList = new ArrayList<>();
        for (Product product : products) {
            Boolean equalsDescription = true;
            for (Category cat : categories)
                if (!product.getCategories().contains(cat)) {
                    equalsDescription = false;
                }
            if (equalsDescription) resultList.add(product);
        }
        return resultList;
    }


    public Boolean addNewProduct(String name, Set<String> description, Set<Category> categories) {
        if (getByName(name) != null) {
            log.info("Error while trying to create new product with name ->" + name + " : product name is exist");
            return false;
        }
        products.add(new Product(idCount++, name, description, categories));
        return true;
    }

}
