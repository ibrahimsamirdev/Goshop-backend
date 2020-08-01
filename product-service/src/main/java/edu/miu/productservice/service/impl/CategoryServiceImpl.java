package edu.miu.productservice.service.impl;

import edu.miu.productservice.exception.NoSuchResourceException;
import edu.miu.productservice.model.Category;
import edu.miu.productservice.repository.CategoryRepository;
import edu.miu.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(long categoryId) throws NoSuchResourceException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new NoSuchResourceException("No Category found  with" , categoryId));

        return category;
    }


    @Override
    public List<Category> getCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public Category editCategory(long categoryId, Category edit_category) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new  NoSuchResourceException("No category found  with" , categoryId));

        category.setDescription(edit_category.getDescription());
        category.setName(edit_category.getName());

        return categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(long categoryId) throws NoSuchResourceException {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchResourceException("No category found  with", categoryId));

        categoryRepository.delete(category);

        return ResponseEntity.noContent().build();
    }

}
