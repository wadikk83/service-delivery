package by.wadikk.servicedelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    /*public Integer orderSum() {
        int result = 0;
        for (OrderItem item : items) {
            result += item.getItemPrice();
        }
        return result;
    }*/

    /*public void addItem(Product product, int amount) {
        OrderItem orderItem = new OrderItem(product, amount);
        for (OrderItem item : items) {
            if (item.getProducts().equals(product)) {
                item.setAmount(item.getAmount() + amount);
            } else {
                items.add(orderItem);
            }
        }
    }*/
}
