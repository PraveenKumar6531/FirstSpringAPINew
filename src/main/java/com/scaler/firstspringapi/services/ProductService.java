package com.scaler.firstspringapi.services;

import com.scaler.firstspringapi.models.Category;
import com.scaler.firstspringapi.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    ResponseEntity<Product> replaceProduct(Long id,Product product);

    ResponseEntity<List<Product>> getCategoryByName(String name);

    List<String> getAllCategories();
}
