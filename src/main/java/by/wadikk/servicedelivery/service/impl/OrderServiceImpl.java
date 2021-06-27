package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.*;
import by.wadikk.servicedelivery.repository.OrderRepository;
import by.wadikk.servicedelivery.repository.impl.OrderRepositoryImpl;
import by.wadikk.servicedelivery.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl().getService();

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAll();
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order createOrder(User user, List<OrderItem> listItems) {
        Order order = new Order(user, listItems);
        return orderRepository.addOrder(order);
    }

    @Override
    public Order addProductToOrderById(Integer id, Shop shop, Product product, Integer amount) {
        Order ord = orderRepository.findById(id);
        OrderItem orderItem = new OrderItem(product, amount, shop);
        ord.getItems().add(orderItem);
        return ord;
    }
}
