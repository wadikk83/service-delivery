package by.wadikk.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {

    private Product product;
    private int amount;
    private double productPrice;
    private Shop shop;


    public double getItemPrice() {
        return productPrice * amount;
    }


}
