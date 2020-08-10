package edu.miu.productservice.controller;

//import com.goshop.productservice.model.Category;
//import com.goshop.productservice.service.CategoryService;
import edu.miu.productservice.model.Category;
import edu.miu.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @PostMapping(value = "/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {

        HttpHeaders headers = new HttpHeaders();

        if (category == null) {
            return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
        }
        categoryService.addCategory(category);

        //headers.add("Category added :", category.);

        return new ResponseEntity<Category>(category, headers, HttpStatus.CREATED);

    }
    //ResponseEntity<List<Category>>
    @GetMapping(value = "/")
    public ResponseEntity<List<Category>> getCategories() {
        ResponseEntity<List<Category>> result;

        HttpHeaders headers = new HttpHeaders();
//        Category c = new Category("Electronics","laptops,phones,PS4",false, Arrays.asList(
//                new Category("Laptop","dell,hp,acer",false,Arrays.asList(
//                        new Category("Dell","laptop",false,null),
//                        new Category("Acer","laptop",false,null)
//                )),
//                new Category("Television","samsung,sony",false,Arrays.asList(
//                        new Category("Samsung","tv",false,null),
//                        new Category("Sony","tv",false,null)
//                ))
//        ));

        List<Category> categories = categoryService.getCategories();

        if (categories == null) {
            result = new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
        } else {
            headers.add("Number of Blocks returned", String.valueOf(categories.size()));
            result = new ResponseEntity<List<Category>>(categories, headers, HttpStatus.OK);
        }

        return result;
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable long categoryId) {

        Category category = categoryService.getCategory(categoryId);

        if (category == null) {

            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PutMapping(value="/{categoryId}")
    public ResponseEntity<Category> editCategory(@PathVariable long categoryId,@RequestBody Category category){

        HttpHeaders headers = new HttpHeaders();
        Category category_toEdit = categoryService.getCategory(categoryId);

        if(category_toEdit == null) {

            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        categoryService.editCategory(categoryId, category);

        headers.add("Updated Block : ",String.valueOf(categoryId));

        return new ResponseEntity<Category>(category,headers, HttpStatus.OK);
    }


    @DeleteMapping(value="/{categoryId}")
    public Category deleteCategory(@PathVariable long categoryId){



        return  categoryService.deleteCategory(categoryId);
    }

    @GetMapping(value = "/subCategories")
    public ResponseEntity<Object> getSubCaregories(){
        return new ResponseEntity<Object>(categoryService.getAllSubCategory(), HttpStatus.OK);
    }
}
