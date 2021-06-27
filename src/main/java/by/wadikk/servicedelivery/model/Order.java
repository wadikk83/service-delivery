package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    Integer id;
    User user;

    private List<OrderItem> items = new ArrayList<>();

    public Order(User user, List<OrderItem> items) {
        this.user = user;
        this.items = items;
    }

    @Override
    public String toString() {
        String out = "Order ID->" + id +
                ", user->" + user.getLogin() +
                ", items->" + "\n";
        for (OrderItem it : items) {
            out += "Product name -> " + it.getProduct().getName() +
                    ", Amount -> " + it.getAmount() +
                    ", Shop name ->" + it.getShop().getName() + "\n";

        }


        return out;
    }
}
