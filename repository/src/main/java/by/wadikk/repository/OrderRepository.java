package by.wadikk.repository;


import by.wadikk.repository.model.User;
import by.wadikk.repository.model.Order;

import java.util.List;


public interface OrderRepository {

    Order findById(Integer id);

    List<Order> findByUser(User user);

    Order addOrder(Order order);

    Boolean deleteById(Integer id);

    List<Order> getAll();
}
