package by.wadikk.servicedelivery.service.impl;


import by.wadikk.servicedelivery.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserServiceImplTest {
    //UserService userService = UserServiceImpl.getService();
    UserService userService = null;

    @Test
    void getByLogin() {
        Assertions.assertNotNull(userService.getByLogin("user1"));
        Assertions.assertNull(userService.getByLogin("test-zzzzzzzzzzzzzzzzzzzz"));
    }

    @Test
    void deleteUser() {
        Assertions.assertTrue(userService.deleteUser(1));
        Assertions.assertFalse(userService.deleteUser(3484));
    }

    @Test
    void editUserById() {
        Assertions.assertNotNull(userService.editUserById(1,"testpassword","testFirstName"));
        Assertions.assertNull(userService.editUserById(3484,"testpassword","testFirstName"));
    }

    @Test
    void editUserByLogin() {
        Assertions.assertNotNull(userService.editUserByLogin("user1","testpassword","testFirstName"));
        Assertions.assertNull(userService.editUserByLogin("4326-zzz","testpassword","testFirstName"));
    }
}