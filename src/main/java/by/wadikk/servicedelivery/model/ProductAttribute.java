package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductAttribute {

    private Integer id;
    private Integer productID;
    private Attribute attribute;
    private Product product;
    private String value;
}
