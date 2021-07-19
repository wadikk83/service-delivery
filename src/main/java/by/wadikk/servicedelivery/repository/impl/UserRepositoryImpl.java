package by.wadikk.servicedelivery.repository.impl;

import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private static UserRepository userRepository;

    private List<User> users = new ArrayList<User>();

    private static Integer idCount = 1;

    public UserRepositoryImpl() {
    }

    //singleton
    public static UserRepository getService() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }


    @Override
    public User findById(Integer id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public User findByName(String name) {
        return users.stream()
                .filter(u -> u.getLogin().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public User add(User user) {
        user.setId(idCount++);
        users.add(user);
        log.info("Add new user ->" + user);
        return user;
    }

    @Override
    public User update(User user) {
        for (User u : users) {
            if (u.getId().equals(user.getId()) || u.getLogin().equals(user.getLogin())) {
                u.setPassword(user.getPassword());
                u.setFirstName(user.getFirstName());
                log.info("Update user with id -> " + u.getId() + " and login->" + u.getLogin());
                return u;
            }
        }
        log.info("Can't update user with id -> " + user.getId() + " and login->" + user.getLogin());
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        User toBeDeleted = findById(id);
        if (toBeDeleted != null) {
            users.remove(toBeDeleted);
            log.info("Detele user " + toBeDeleted);
            return true;
        }
        log.info("User with id " + id + " can't be deleted - user not found");
        return false;
    }

    @Override
    public List<User> getAll() {
        return users;
    }


}
