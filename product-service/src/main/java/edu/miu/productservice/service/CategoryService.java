package edu.miu.productservice.service;

import edu.miu.productservice.exception.NoSuchResourceException;
import edu.miu.productservice.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    public  Category addCategory(Category category);
    public Category getCategory(long categoryId) throws NoSuchResourceException;
    public List<Category> getCategories();

    public Category editCategory(long categoryId, Category edit_category);
    public Category deleteCategory(long categoryId) throws NoSuchResourceException;

    List<Category> getAllSubCategory();

    List<Category> getAllParentCategory();
}
