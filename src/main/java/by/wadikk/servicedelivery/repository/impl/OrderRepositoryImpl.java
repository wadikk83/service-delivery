package by.wadikk.servicedelivery.repository.impl;

import by.wadikk.servicedelivery.model.Order;
import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.repository.OrderRepository;
import by.wadikk.servicedelivery.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepository orderRepository;

    private List<Order> orders = new ArrayList<Order>();

    private static Integer idCount = 1;

    public OrderRepositoryImpl() {
    }

    //singleton
    public static OrderRepository getService() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl();
        }
        return orderRepository;
    }


    @Override
    public Order findById(Integer id) {
        return orders.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Order> findByUser(User user) {
        return (List<Order>) orders.stream()
                .filter(u -> u.getUser().equals(user))
                .findAny()
                .orElse(null);
    }

    @Override
    public Order addOrder(Order order) {
        // TODO: 17.07.2021 Rewrite this method
        /*order.setId(idCount++);
        orders.add(order);
        log.info("Add new order ->" + order);*/
        return order;
    }

    @Override
    public Boolean deleteById(Integer id) {
        Order toBeDeleted = findById(id);
        if (toBeDeleted != null) {
            orders.remove(toBeDeleted);
            log.info("Detele order " + toBeDeleted);
            return true;
        }
        log.info("Order with id " + id + " can't be deleted - user not found");
        return false;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }
}
