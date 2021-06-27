package by.wadikk.servicedelivery.util;


import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.service.CategoryService;
import by.wadikk.servicedelivery.service.ProductService;
import by.wadikk.servicedelivery.service.UserService;
import by.wadikk.servicedelivery.service.impl.CategoryServiceImpl;
import by.wadikk.servicedelivery.service.impl.ProductServiceImpl;
import by.wadikk.servicedelivery.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.*;

public class Runner {

    UserService userService = new UserServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    ProductService productService = new ProductServiceImpl();
    /*ProductService productService = ProductServiceImpl.getService();
    ShopService shopService = ShopServiceImpl.getService();*/

    public void run() throws IOException {

        System.out.println("Save shop to Json");
        JsonUtil jsonUtil = new JsonUtil();
        //jsonUtil.parseJsonListToFile(shopService.getAllShops(), "Json shop");

        /*categoryService.getRootCategory();

        productService.findProductByDescription("Prod1-dsc1", "Prod2-dsc2");

        Shop shop = shopService.getById(1);
        System.out.println("Print product amount");
        for (Map.Entry<Product, Integer> entry : shop.getProductAmount().entrySet()) {
            System.out.println("Product name -> " + entry.getKey().getName() + " Amount -> " + entry.getValue());
        }*/

    }

    public void dataPreparation() {
        System.out.println("Create new user with login->admin, password->admin, first name-> admin");
        userService.addNewUser("admin", "admin", "admin");


        System.out.println("Create new user with login->user1, password->user1, first name-> user1");
        userService.addNewUser("user1", "user1", "user1");

        System.out.println("Create new user with login->user2, password->user2, first name-> user2");
        userService.addNewUser("user2", "user2", "user2");

        System.out.println("Create categories");
        System.out.println("Create new category with name -> Child 1 (under Root)");
        categoryService.addNewCategory("Child 1 (under Root)");

        System.out.println("Create new category with name -> Child 2 (under Root)");
        categoryService.addNewCategory("Child 2 (under Root)");

        System.out.println("Create new category with name -> Child 3 (under Child 2)");
        categoryService.addNewCategory("Child 3 (under Child 2)", "Child 2 (under Root)");

        System.out.println("Create new category with name -> Child 4 (under Child 3)");
        categoryService.addNewCategory("Child 4 (under Child 3)", "Child 3 (under Child 2)");

        System.out.println("Print tree categories");
        categoryService.printTree();


        Set<String> product1Description = new HashSet<>();
        product1Description.add("Prod1-dsc1");
        product1Description.add("Prod1-dsc2");
        product1Description.add("Prod1-dsc3");
        Set<Category> product1Category = new HashSet<>();
        Category cat1 = categoryService.getCategoryByName("Root");
        Category cat2 = categoryService.getCategoryByName("Child 1 (under Root)");
        product1Category.add(cat2);

        product1Category.add(cat1);
        //product1Category.add(categoryService.getCategoryByName("Root"));
        //product1Category.add(categoryService.getCategoryByName("Child 1 (under Root)"));
        productService.addNewProduct("Product1", product1Description, product1Category);
        System.out.println("Create new product -> " + productService.getByName("Product1").toString());

        Set<String> product2Description = new HashSet<>();
        product2Description.add("Prod2-dsc1");
        product2Description.add("Prod2-dsc2");
        product2Description.add("Prod2-dsc3");
        Set<Category> product2Category = new HashSet<>();
        //product2Category.add(categoryService.getCategoryByName("Root"));
        productService.addNewProduct("Product2", product2Description, product2Category);
        System.out.println("Create new product -> " + productService.getByName("Product2").toString());

        Set<String> product3Description = new HashSet<>();
        product3Description.add("Prod3-dsc1");
        product3Description.add("Prod3-dsc2");
        product3Description.add("Prod3-dsc3");
        Set<Category> product3Category = new HashSet<>();
        //product3Category.add(categoryService.getCategoryByName("Root"));
        productService.addNewProduct("Product3", product3Description, product3Category);
        System.out.println("Create new product -> " + productService.getByName("Product3").toString());


        /*shopService.createShop("Shop1", "My super shop 1");
        shopService.editProductPriceAndAmountByShopId(1, productService.getById(1), 5, 5);
        shopService.editProductPriceAndAmountByShopId(1, productService.getById(2), 10, 10);
        System.out.println("Create new shop -> " + shopService.getByName("Shop1").toString());

        shopService.createShop("Shop2", "My super shop 2");
        shopService.editProductPriceAndAmountByShopId(2, productService.getById(1), 15, 15);
        shopService.editProductPriceAndAmountByShopId(2, productService.getById(2), 20, 20);
        System.out.println("Create new shop -> " + shopService.getByName("Shop2").toString());
*/

    }

}
