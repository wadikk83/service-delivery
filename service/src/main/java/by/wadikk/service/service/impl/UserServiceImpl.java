package by.wadikk.service.service.impl;


import by.wadikk.repository.UserRepository;
import by.wadikk.repository.model.User;
import by.wadikk.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
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
