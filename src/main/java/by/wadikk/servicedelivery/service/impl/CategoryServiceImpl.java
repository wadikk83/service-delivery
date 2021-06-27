package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private static CategoryService categoryService;

    private Category categories = new Category("Root");

    CategoryServiceImpl() {

        new Category("Child 1 (under Root)", getCategoryByName(categories, "Root"));
        new Category("Child 2 (under Root)", getCategoryByName(categories, "Root"));
        new Category("Child 3 (under Child 2)", getCategoryByName(categories, "Child 2 (under Root)"));
        new Category("Child 4 (under Child 3)", getCategoryByName(categories, "Child 3 (under Child 2)"));
        new Category("Child 5 (under Root)", getCategoryByName(categories, "Root"));
    }

    public static CategoryService getService() {
        if (categoryService == null) {
            categoryService = new CategoryServiceImpl();
        }
        return categoryService;
    }

    private List<Category> traverse(Category category) {
        /*List<Category> resultList = new ArrayList<>();

        if (category != null || category.getChildren() != null) {
            for (Category cat : categories.getChildren()) {
                if (cat.getChildren() != null) resultList.addAll(traverse(cat.getChildren()));
            }
        }
        return resultList;*/
        return null;
    }

    @Override
    public Category getRootCategory() {
        return categories;
    }

    // TODO: 27.06.2021 Don't work
    public List<Category> getAllCategories() {
        List<Category> resultsList = new ArrayList<Category>();
        if (categories.getChildren() != null) {
            for (Category cat : categories.getChildren()) {
                //resultsList.add(cat);
                resultsList.addAll(traverse(cat));
            }
        }
        return resultsList;
    }

    public void traverse1(Category category) {
        if (category != null) {
            for (Category cat : category.getChildren()) {
                System.out.println(cat.getName().toString());
                traverse1(cat);
            }
        }
        return;
    }

    @Override
    public Category getCategoryByName(Category root, String name) {
        //Category foundByName;
        if (name == "Root") return categories;

        for (Category child : root.getChildren()) {
            //System.out.println("Name: " + name + " -> Child name: " + child.getName());
            if (child.getName().equals(name)) {
                return child;
            }
            Category result = getCategoryByName(child, name);
            if (result != null) return result;
        }
        return null;
    }

    @Override
    public void printTree(List<Category> categoryList) {
        for (Category cat : categoryList) {
            cat.toString();
        }
    }
}