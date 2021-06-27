package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;

    private Set<String> description;

    private Set<Category> categories;

    public Product(String name, Set<String> description, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.categories = categories;
    }
}
