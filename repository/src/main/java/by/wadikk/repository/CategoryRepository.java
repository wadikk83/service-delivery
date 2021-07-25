package by.wadikk.repository;

import by.wadikk.repository.model.Category;

import java.util.List;

public interface CategoryRepository {

    Category findById(Integer id);

    Category findByName(String categoryName);

    List<Category> getAll();

    Category getRootCategory();

    Category addCategory(String nameCategory, String parent);

    void printTreeCategories();

}
