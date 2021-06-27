package by.wadikk.servicedelivery.repository;

import by.wadikk.servicedelivery.model.User;

import java.util.*;

public interface UserRepository {

    User findById(Integer id);

    User findByLogin(String loginName);

    User addUser(User user);

    User updateUser(User user);

    Boolean deleteById(Integer id);

    List<User> getAll();
}
