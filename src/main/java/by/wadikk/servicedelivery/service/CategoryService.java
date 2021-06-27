package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.Category;

import java.util.List;

public interface CategoryService {

    Category getRootCategory();

    List<Category> getAllCategories();

    Category getCategoryByName(String name);

    void printTree();

    Category addNewCategory(String nameCategory, String parent);

    Category addNewCategory(String nameCategory);
}
