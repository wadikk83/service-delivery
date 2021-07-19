package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.repository.UserRepository;
import by.wadikk.servicedelivery.repository.impl.UserRepositoryImpl;
import by.wadikk.servicedelivery.service.UserService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//@XmlRootElement(name = "users")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl().getService();

    @Override
    //@XmlElement(name = "user")
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByName(login);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userRepository.deleteById(id);
    }

    @Override
    public User editUserById(Integer id, String password, String firstName) {
        User user = userRepository.findById(id);
        user.setPassword(password);
        user.setFirstName(firstName);
        return userRepository.update(user);
    }

    @Override
    public User editUserByLogin(String login, String password, String firstName) {
        User user = userRepository.findByName(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        return userRepository.update(user);
    }

    @Override
    public User addNewUser(String login, String password, String firstName) {
        User user = new User(login, password, firstName);
        return userRepository.add(user);
    }
}
