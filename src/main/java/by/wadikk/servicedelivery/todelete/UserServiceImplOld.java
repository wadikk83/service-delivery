package by.wadikk.servicedelivery.todelete;

import by.wadikk.servicedelivery.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * UserService implementation
 */
@Slf4j
public class UserServiceImplOld implements UserServiceOld {

    private static UserServiceOld userService;

    private static Integer idCount = 1;

    private List<User> users = new ArrayList<User>();

    private UserServiceImplOld() {
        //Create default user admin
        users.add(new User(idCount++, "admin", "admin", "admin"));
        log.info("Create default user admin");
    }

    //singleton
    public static UserServiceOld getService() {
        if (userService == null) {
            userService = new UserServiceImplOld();
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
        if (id == null) return null;
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

    @Override
    public User addNewUser(String login, String password, String firstName) {
        if (getByLogin(login) != null) {
            log.info("User with login " + login + " is exist");
            return getByLogin(login);
        }
        users.add(new User(idCount++, login, password, firstName));
        log.info("Create new user -> " + getByLogin(login).toString());
        return getByLogin(login);
    }
}
