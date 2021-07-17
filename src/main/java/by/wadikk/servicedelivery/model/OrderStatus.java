package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OrderStatus {
    private Integer id;
    private String statusName;

    private Order order;

    private String description;

}
