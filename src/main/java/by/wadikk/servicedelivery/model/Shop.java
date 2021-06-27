package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Shop {
    Integer id;
    String name;
    String description;

    Map<Product, Integer> productPrice = new HashMap<>();

    Map<Product, Integer> productAmount = new HashMap<>();
}
