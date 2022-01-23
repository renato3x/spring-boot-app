package com.website.course.services;

import com.website.course.entities.Category;
import com.website.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Long id) {
    return categoryRepository.findById(id).get();
  }
}
