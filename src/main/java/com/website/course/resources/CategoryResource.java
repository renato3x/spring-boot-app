package com.website.course.resources;

import com.website.course.entities.Category;
import com.website.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    return ResponseEntity.ok().body(categoryService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(categoryService.findById(id));
  }
}
