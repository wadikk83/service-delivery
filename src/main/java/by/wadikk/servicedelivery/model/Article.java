package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {

    private Integer id;
    private Product product;
    private Shop store;
    private double price;
    int amount;
}
