package by.wadikk.servicedelivery.repository;

import by.wadikk.servicedelivery.model.Order;
import by.wadikk.servicedelivery.model.User;

import java.util.List;


public interface OrderRepository {

    Order findById(Integer id);

    List<Order> findByUser(User user);

    Order addOrder(Order order);

    Boolean deleteById(Integer id);

    List<Order> getAll();
}
