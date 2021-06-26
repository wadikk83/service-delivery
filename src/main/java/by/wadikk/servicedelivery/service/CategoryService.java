package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category findCategoryByName(String name);

}
