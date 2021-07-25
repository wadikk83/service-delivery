package by.wadikk.repository;


import by.wadikk.repository.model.User;

import java.util.List;


public interface GeneralRepository<T, ID> {

    User findById(ID id);

    User findByName(String name);

    T add(T t);

    T update(T t);

    Boolean deleteById(ID id);

    List<User> getAll();
}
