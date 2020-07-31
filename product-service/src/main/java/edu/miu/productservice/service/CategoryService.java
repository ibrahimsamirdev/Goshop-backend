package edu.miu.productservice.service;

import edu.miu.productservice.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category getCategory(long categoryId);
    public Category editCategory(long categoryId, Category edit_category);
    public ResponseEntity<Void> deleteCategory(long categoryId);
    public List<Category> getCategories();
}
