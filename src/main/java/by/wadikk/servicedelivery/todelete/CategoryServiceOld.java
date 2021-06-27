package by.wadikk.servicedelivery.todelete;

import by.wadikk.servicedelivery.model.Category;

import java.util.List;

public interface CategoryServiceOld {

    Category getRootCategory();

    List<Category> getAllCategories();

    Category getCategoryByName(Category root, String name);

    void printTree();

    Boolean addNewCategory(String nameCategory, String parent);

    Boolean addNewCategory(String nameCategory);

}
