package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;

    private String description1;
    private String description2;

    private Set<Category> categories;

}
