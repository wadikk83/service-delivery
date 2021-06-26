package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.service.ShopService;
import by.wadikk.servicedelivery.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceImplTest {

    ShopService shopService = ShopServiceImpl.getService();

    @Test
    void getByName() {
        Assertions.assertNotNull(shopService.getByName("Shop2"));
        Assertions.assertNull(shopService.getByName("test-zzzzzzzzzzzzzzzzzzzz"));
    }

    @Test
    void deleteShop() {
        Assertions.assertTrue(shopService.deleteShop(1));
        Assertions.assertFalse(shopService.deleteShop(3484));
    }

    @Test
    void editShopById() {
        Assertions.assertNotNull(shopService.editShopById(1,"test shop","test description"));
        Assertions.assertNull(shopService.editShopById(3489,"test shop","test description"));
    }
}