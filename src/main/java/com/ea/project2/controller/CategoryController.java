package com.ea.project2.controller;

import com.ea.project2.entity.Category;
import com.ea.project2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category) throws Exception {
        return categoryService.createCategory(category);
    }

    @PatchMapping("/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable("id") Long id) throws Exception {
        return categoryService.updateCategory(category, id);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return categoryService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable("id") Long id) throws Exception {
        return categoryService.deleteCategory(id);
    }


}
