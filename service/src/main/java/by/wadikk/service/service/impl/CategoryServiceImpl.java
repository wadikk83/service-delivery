package by.wadikk.service.service.impl;


import by.wadikk.repository.CategoryRepository;
import by.wadikk.repository.model.Category;
import by.wadikk.service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getRootCategory() {
        return categoryRepository.getRootCategory();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public void printTree() {
        categoryRepository.printTreeCategories();
    }

    @Override
    public Category addNewCategory(String nameCategory, String parent) {
        return categoryRepository.addCategory(nameCategory, parent);
    }

    @Override
    public Category addNewCategory(String nameCategory) {
        return categoryRepository.addCategory(nameCategory, categoryRepository.getRootCategory().getName());
    }
}
