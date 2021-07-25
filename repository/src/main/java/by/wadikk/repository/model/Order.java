package by.wadikk.repository.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

public class Order {

    private String id;
    private User user;
    private Shop shop;
    private List<OrderStatus> orderStatusList;
    private Date dateCreated;

    private List<OrderItem> items = new ArrayList<>();


}
