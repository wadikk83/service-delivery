package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.service.UserService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserServiceImpl implements UserService {

    private static UserService userService;

    private List<User> users = new ArrayList<User>();

    private UserServiceImpl() {
        users.add(new User(1, "user1", "password1", "NameUser1"));
        users.add(new User(2, "user2", "password2", "NameUser2"));
        users.add(new User(3, "user3", "password3", "NameUser3"));
        log.info("Create user service with users" + users.toString());
    }

    public static UserService getService() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getByLogin(String login) {
        return users.stream().filter(u -> u.getLogin().equals(login)).findAny().orElse(null);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        User toBeDeleted = users.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeDeleted != null) {
            users.remove(toBeDeleted);
            log.info("Detele user " + toBeDeleted);
            return true;
        }
        log.info("User with id " + id + " can't be deleted - user not found");
        return false;
    }

    @Override
    public User editUserById(Integer id, String password, String firstName) {
        if (id ==null) return null;
        User toBeEdit = users.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeEdit != null) {
            log.info("Edit user " + toBeEdit);
            toBeEdit.setPassword(password);
            toBeEdit.setFirstName(firstName);
            log.info("User after edit " + toBeEdit);
            return toBeEdit;
        }
        log.info("User with id " + id + " not found");
        return null;
    }

    @Override
    public User editUserByLogin(String login, String password, String firstName) {
        User toBeEdit = getByLogin(login);
        if (toBeEdit == null) return null;
        return editUserById(toBeEdit.getId(), password, firstName);
    }


}
