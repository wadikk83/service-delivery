package by.wadikk.servicedelivery.repository;


import java.util.List;

public interface GeneralRepository<T, ID> {

    T findById(ID id);

    T findByName(String name);

    T add(T t);

    T update(T t);

    Boolean deleteById(ID id);

    List<T> getAll();
}
