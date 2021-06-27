package by.wadikk.servicedelivery.service;

import by.wadikk.servicedelivery.model.Category;

import java.util.List;

public interface CategoryService {

    Category getRootCategory();

    List<Category> getAllCategories();

    Category getCategoryByName(Category root, String name);

    void printTree(List<Category> categoryList);

    void traverse1(Category category);

}
