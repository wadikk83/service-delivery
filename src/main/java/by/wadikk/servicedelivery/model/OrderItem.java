package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {

    private Product product;
    private int amount;
    private Shop shop;


    public int getItemPrice() {
        return shop.getAmountAndPrice().get(product).getPrice() * amount;
    }


}
