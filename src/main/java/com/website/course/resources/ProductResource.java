package com.website.course.resources;

import com.website.course.entities.Product;
import com.website.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    return ResponseEntity.ok().body(productService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(productService.findById(id));
  }
}
