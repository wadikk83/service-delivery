package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor

public class OrderStatus {
    private Integer id;
    private String statusName;
    private Date timestamp;

    private Order order;

    private String description;

}
