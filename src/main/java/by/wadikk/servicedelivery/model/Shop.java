package by.wadikk.servicedelivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Shop {
    Integer id;
    String name;
    String description;

    List<Article> articleList = null;

}
