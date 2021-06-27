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

    Map<Product, WrapperForAmountPrice> amountAndPrice = new HashMap<>();

    public Shop(String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        String out = "Shop ID->" + id +
                ", name->" + name +
                ", description->" + description + "\n";

        for (Product key : amountAndPrice.keySet()) {
            out += "Product ->" + key.getName() +
                    " Amount -> " + amountAndPrice.get(key).getAmount() +
                    " Price -> " + amountAndPrice.get(key).getPrice() + "\n";

        }
        return out;
    }
}
