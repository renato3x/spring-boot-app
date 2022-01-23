package com.website.course.services;

import com.website.course.entities.Product;
import com.website.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(Long id) {
    return productRepository.findById(id).get();
  }
}
