package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    User getByLogin(String login);

    Boolean deleteUser(Integer id);

    User editUserById(Integer id, String password, String firstName);

    User editUserByLogin(String login, String password, String firstName);

    User addNewUser(String login, String password, String firstName);


}
