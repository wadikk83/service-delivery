package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.*;
import by.wadikk.servicedelivery.repository.OrderRepository;
import by.wadikk.servicedelivery.repository.impl.OrderRepositoryImpl;
import by.wadikk.servicedelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

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
        //// TODO: 17.07.2021 Rewrite this method
        /*Order order = new Order(user, listItems);
        return orderRepository.addOrder(order);*/
        return null;
    }

    @Override
    public Order addProductToOrderById(Integer id, Shop shop, Product product, Integer amount) {
        // TODO: 17.07.2021 Rewrite this method

        /*Order ord = orderRepository.findById(id);
        OrderItem orderItem = new OrderItem(product, amount, shop);
        ord.getItems().add(orderItem);
        return ord;*/
        return null;
    }
}
