package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Order;
import by.wadikk.servicedelivery.model.OrderItem;
import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.service.OrderService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderServiceImpl implements OrderService {

    private static OrderService orderService;

    private List<Order> orders = new ArrayList<Order>();

    private static Integer idCount = 1;

    public OrderServiceImpl() {
    }

    //singleton
    public static OrderService getService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public Order getById(Integer id) {

        return orders.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Boolean createOrder(User user, List<OrderItem> listItems) {

        orders.add(new Order(idCount++, user, listItems));
        return true;
    }
}
