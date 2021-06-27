package by.wadikk.servicedelivery.service.impl;


import by.wadikk.servicedelivery.todelete.UserServiceImplOld;
import by.wadikk.servicedelivery.todelete.UserServiceOld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserServiceImplTest {
    UserServiceOld userService = UserServiceImplOld.getService();

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