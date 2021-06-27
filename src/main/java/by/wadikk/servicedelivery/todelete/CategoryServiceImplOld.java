package by.wadikk.servicedelivery.todelete;

import by.wadikk.servicedelivery.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImplOld implements CategoryServiceOld {

    private static CategoryServiceOld categoryService;

    private static Integer idCount = 1;

    private Category categories = new Category(idCount++, "Root");

    private final List<Category> allCategoryList = new ArrayList<>();

    CategoryServiceImplOld() {
    }

    //singleton
    public static CategoryServiceOld getService() {
        if (categoryService == null) {
            categoryService = new CategoryServiceImplOld();
        }
        return categoryService;
    }

    @Override
    public Category getRootCategory() {
        return categories;
    }

    //depth traversal
    private void traverse(Category category) {
        if (category != null) {
            for (Category cat : category.getChildren()) {
                allCategoryList.add(cat);
                traverse(cat);
            }
        }
    }

    //return list all categories
    public List<Category> getAllCategories() {
        allCategoryList.clear();
        traverse(getRootCategory());
        return allCategoryList;
    }

    @Override
    public Category getCategoryByName(Category root, String name) {
        //Category foundByName;
        if (name == "Root") return categories;
        List<Category> allCategories = getAllCategories();
        for (Category cat : allCategories) {
            if (cat.getName().equals(name)) {
                return cat;
            }
        }
        return null;
    }

    @Override
    public void printTree() {
        printTreeByCategory(getRootCategory());
    }

    @Override
    public Boolean addNewCategory(String nameCategory, String parent) {
        new Category(idCount++, nameCategory, getCategoryByName(getRootCategory(), parent));
        if (getCategoryByName(getRootCategory(), nameCategory) != null) {
            //if the category is created
            return true;
        }
        return false;
    }

    @Override
    public Boolean addNewCategory(String nameCategory) {
        return addNewCategory(nameCategory, "Root");
    }

    public void printTreeByCategory(Category category) {
        if (category != null) {
            for (Category cat : category.getChildren()) {
                System.out.println(cat.toString());
                printTreeByCategory(cat);
            }
        }
    }
}