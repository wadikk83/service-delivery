package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.service.CategoryService;
import by.wadikk.servicedelivery.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImplOld implements CategoryService {
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category findCategoryByName(String name) {
        return null;
    }

    @Override
    public Category findCategoryById(Integer id) {
        return null;
    }
    /*private static CategoryService categoryService;

    private List<Category> categories = new ArrayList<Category>();

    private CategoryServiceImpl() {


        Category cat3 = new Category(3, "Children2", new ArrayList<>() );
        Category cat2 = new Category(2, "Children1", Arrays.asList(cat3) );
        Category cat1 = new Category(1, "Parent", Arrays.asList(cat2));

        categories.add(cat1);
    }

    public static CategoryService getService() {
        if (categoryService == null) {
            categoryService = new CategoryServiceImpl();
        }
        return categoryService;
    }


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category findCategoryByName(String name) {
        List<Category> list = categories.stream()
                .flatMap(children -> children.getChildrenList().stream())
                .filter(u -> u.getName().equals(name))
                .collect(Collectors.toList());
        System.out.println(list);
        for (Category cat : list) {
            System.out.println(cat.getName());

        }
        return null;
    }

    @Override
    public Category findCategoryById(Integer id) {
        return null;
    }*/
}
