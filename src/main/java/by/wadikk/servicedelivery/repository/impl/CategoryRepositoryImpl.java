package by.wadikk.servicedelivery.repository.impl;

import by.wadikk.servicedelivery.model.Category;
import by.wadikk.servicedelivery.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private static CategoryRepository categoryRepository;

    private Category categories = new Category(idCount++, "Root");

    private static Integer idCount = 1;

    private final List<Category> allCategoryList = new ArrayList<>();

    public CategoryRepositoryImpl() {
    }

    //singleton
    public static CategoryRepository getService() {
        if (categoryRepository == null) {
            categoryRepository = new CategoryRepositoryImpl();
        }
        return categoryRepository;
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

    private List<Category> getCategoryList() {
        allCategoryList.clear();
        traverse(getRootCategory());
        return allCategoryList;
    }

    @Override
    public Category findById(Integer id) {
        if (id == 1) return categories;
        return getCategoryList().stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Category findByName(String categoryName) {
        if (categoryName == "Root") return categories;
        return getCategoryList().stream()
                .filter(u -> u.getName().equals(categoryName))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return getCategoryList();
    }

    @Override
    public Category getRootCategory() {
        return categories;
    }

    @Override
    public Category addCategory(String nameCategory, String parent) {
        Category newCategory = new Category(idCount++, nameCategory, findByName(parent));
        if (findByName(nameCategory) != null) {
            //if the category is created
            return newCategory;
        }
        return null;
    }

    public void printTreeByCategory(Category category) {
        if (category != null) {
            for (Category cat : category.getChildren()) {
                System.out.println(cat.toString());
                printTreeByCategory(cat);
            }
        }
    }

    @Override
    public void printTreeCategories() {
        printTreeByCategory(getRootCategory());

    }
}
