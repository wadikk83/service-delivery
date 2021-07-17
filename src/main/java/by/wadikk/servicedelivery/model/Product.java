package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;

    private Set<Category> categories;

    private List<ProductAttribute> productAttributes = null;

}
