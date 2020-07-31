package com.goshop.productservice.service;

import com.goshop.productservice.exception.NoSuchResourceException;
import com.goshop.productservice.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    public  Category addCategory(Category category);
    public Category getCategory(long categoryId) throws NoSuchResourceException;
    public List<Category> getCategories();
    public Category editCategory(long categoryId, Category edit_category);
    public ResponseEntity<Void> deleteCategory(long categoryId) throws NoSuchResourceException;
}
