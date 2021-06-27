package by.wadikk.servicedelivery.todelete;

import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.repository.UserRepository;

import java.util.List;

public interface UserServiceOld {

    List<User> getAllUsers();

    User getByLogin(String login);

    Boolean deleteUser(Integer id);

    User editUserById(Integer id, String password, String firstName);

    User editUserByLogin(String login, String password, String firstName);

    User addNewUser(String login, String password, String firstName);


}
