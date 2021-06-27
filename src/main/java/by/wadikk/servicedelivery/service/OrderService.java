package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.*;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getById(Integer id);

    Order createOrder(User user, List<OrderItem> listItems);

    Order addProductToOrderById(Integer id, Shop shop, Product product, Integer amount);
}
