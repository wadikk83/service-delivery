package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.repository.UserRepository;
import by.wadikk.servicedelivery.repository.impl.UserRepositoryImpl;
import by.wadikk.servicedelivery.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userRepository.deleteById(id);
    }

    @Override
    public User editUserById(Integer id, String password, String firstName) {
        return null;
    }

    @Override
    public User editUserByLogin(String login, String password, String firstName) {
        return null;
    }

    @Override
    public User addNewUser(String login, String password, String firstName) {
        User user = new User(login, password, firstName);
        return userRepository.addUser(user);
    }
}
