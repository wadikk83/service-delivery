package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.Order;
import by.wadikk.servicedelivery.model.OrderItem;
import by.wadikk.servicedelivery.model.User;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getById(Integer id);

    Boolean createOrder(User user, List<OrderItem> listItems);
}
