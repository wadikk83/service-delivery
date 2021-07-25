package by.wadikk.service.service;

import by.wadikk.repository.model.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    User getByLogin(String login);

    Boolean deleteUser(Integer id);

    User editUserById(Integer id, String password, String firstName);

    User editUserByLogin(String login, String password, String firstName);

    User addNewUser(String login, String password, String firstName);


}
