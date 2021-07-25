package by.wadikk.service.service;

import by.wadikk.repository.model.*;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getById(Integer id);

    Order createOrder(User user, List<OrderItem> listItems);

    Order addProductToOrderById(Integer id, Shop shop, Product product, Integer amount);
}
