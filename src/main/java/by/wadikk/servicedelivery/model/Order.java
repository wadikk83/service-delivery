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


}
