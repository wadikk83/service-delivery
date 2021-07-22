package by.wadikk.servicedelivery.repository;

import by.wadikk.servicedelivery.model.Category;

import java.util.List;


public interface CategoryRepository {

    Category findById(Integer id);

    Category findByName(String categoryName);

    List<Category> getAll();

    Category getRootCategory();

    Category addCategory(String nameCategory, String parent);

    void printTreeCategories();

}
