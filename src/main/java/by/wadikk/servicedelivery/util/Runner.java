package by.wadikk.servicedelivery.util;


import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.model.Order;
import by.wadikk.servicedelivery.model.OrderItem;
import by.wadikk.servicedelivery.service.*;
import by.wadikk.servicedelivery.service.impl.*;

import java.io.IOException;
import java.util.*;

public class Runner {

    UserService userService = new UserServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    ProductService productService = new ProductServiceImpl();
    ShopService shopService = new ShopServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    public void run() throws IOException {

        JsonUtil jsonUtil = new JsonUtil();

        jsonUtil.parseJsonListToFile(shopService.getAllShops(), "Json shop");
        jsonUtil.parseJsonListToFile(productService.getAllProduct(), "Json product");
        jsonUtil.parseJsonListToFile(userService.getAllUsers(), "Json user");

        System.out.println("==========================================================================");
        System.out.println("Edit/delete user interface");
        System.out.println("All list users");
        System.out.println(userService.getAllUsers());
        System.out.println("Detele user with id = 3");
        System.out.println("Rename user1 to userrrrz");
        userService.deleteUser(3);
        userService.editUserByLogin("user1", "psw", "userrrrz");
        System.out.println(userService.getAllUsers());

        System.out.println("==========================================================================");
        System.out.println("Edit/delete shop interface");
        System.out.println("All list shops");
        System.out.println(shopService.getAllShops());
        System.out.println("Detele shop with id = 2");
        System.out.println("Rename description  and name on shop1 to My shop");
        shopService.deleteShop(2);
        shopService.editShopById(1, "My shop", "My shop");
        System.out.println(shopService.getAllShops());
        System.out.println("==========================================================================");
        System.out.println("Set amound and price to 100 in product with id=1");
        shopService.editProductPriceAndAmountByShopId(1, productService.getById(1), 100, 100);
        System.out.println(shopService.getAllShops());
        System.out.println("==========================================================================");
        System.out.println("Find Product by description Prod2-dsc2");
        System.out.println(productService.findProductByDescription("Prod2-dsc2"));
        System.out.println("Find Product by description Prod3-dsc2 and Prod3-dsc3");
        System.out.println(productService.findProductByDescription("Prod3-dsc2", "Prod3-dsc3"));
        System.out.println("==========================================================================");
        System.out.println("View product in 'Child 1 (under Root)' category");
        System.out.println(productService.findProductByCategory(categoryService.getCategoryByName("Child 1 (under Root)")));
        System.out.println("View product in 'Root' category");
        System.out.println(productService.findProductByCategory(categoryService.getCategoryByName("Root")));
        System.out.println("==========================================================================");
        System.out.println("Ordering");
        System.out.println("All orders");
        System.out.println(orderService.getAllOrders());
        System.out.println("Add order");
        Order testOrder = orderService.createOrder(userService.getByLogin("admin"), new ArrayList<OrderItem>());
        /*testOrder = orderService.addProductToOrderById(testOrder.getId(), shopService.getById(1),
                productService.getById(1), 10);

        testOrder = orderService.addProductToOrderById(testOrder.getId(), shopService.getById(1),
                productService.getById(2), 20);
        System.out.println(orderService.getAllOrders());*/

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
        product1Category.add(categoryService.getCategoryByName("Root"));
        product1Category.add(categoryService.getCategoryByName("Child 1 (under Root)"));
        productService.addNewProduct("Product1", product1Description, product1Category);
        System.out.println("Create new product -> " + productService.getByName("Product1").toString());

        Set<String> product2Description = new HashSet<>();
        product2Description.add("Prod2-dsc1");
        product2Description.add("Prod2-dsc2");
        product2Description.add("Prod2-dsc3");
        Set<Category> product2Category = new HashSet<>();
        product2Category.add(categoryService.getCategoryByName("Root"));
        productService.addNewProduct("Product2", product2Description, product2Category);
        System.out.println("Create new product -> " + productService.getByName("Product2").toString());

        Set<String> product3Description = new HashSet<>();
        product3Description.add("Prod3-dsc1");
        product3Description.add("Prod3-dsc2");
        product3Description.add("Prod3-dsc3");
        Set<Category> product3Category = new HashSet<>();
        product3Category.add(categoryService.getCategoryByName("Root"));
        productService.addNewProduct("Product3", product3Description, product3Category);
        System.out.println("Create new product -> " + productService.getByName("Product3").toString());


        shopService.createShop("Shop1", "My super shop 1");
        shopService.editProductPriceAndAmountByShopId(1, productService.getById(1), 5, 5);
        shopService.editProductPriceAndAmountByShopId(1, productService.getById(2), 10, 10);
        System.out.println("Create new shop -> " + shopService.getByName("Shop1").toString());

        shopService.createShop("Shop2", "My super shop 2");
        shopService.editProductPriceAndAmountByShopId(2, productService.getById(1), 15, 15);
        shopService.editProductPriceAndAmountByShopId(2, productService.getById(2), 20, 20);
        System.out.println("Create new shop -> " + shopService.getByName("Shop2").toString());

        //shopService.sortedProductByPrice(1);
    }

}
