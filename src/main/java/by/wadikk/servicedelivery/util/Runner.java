package by.wadikk.servicedelivery.util;


import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.service.CategoryService;
import by.wadikk.servicedelivery.service.ProductService;
import by.wadikk.servicedelivery.service.ShopService;
import by.wadikk.servicedelivery.service.UserService;
import by.wadikk.servicedelivery.service.impl.CategoryServiceImpl;
import by.wadikk.servicedelivery.service.impl.ProductServiceImpl;
import by.wadikk.servicedelivery.service.impl.ShopServiceImpl;
import by.wadikk.servicedelivery.service.impl.UserServiceImpl;

import java.io.IOException;

public class Runner {

    UserService userService = UserServiceImpl.getService();
    CategoryService categoryService = CategoryServiceImpl.getService();
    ProductService productService = ProductServiceImpl.getService();
    ShopService shopService = ShopServiceImpl.getService();

    public void run() throws IOException {

        /*JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.parseJsonListToFile(userService.getAllUsers(), "Json user");*/

        categoryService.getRootCategory();

        productService.findProductByDescription("Prod1-dsc1","Prod2-dsc2");


    }

}
