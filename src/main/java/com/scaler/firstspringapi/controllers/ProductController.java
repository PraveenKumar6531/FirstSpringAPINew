package com.scaler.firstspringapi.controllers;

import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import com.scaler.firstspringapi.models.Category;
import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.replaceProduct(id,product);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<Product>> getCategoryByName(@PathVariable("name") String name){
        return productService.getCategoryByName(name);
    }
    @GetMapping("/categories")
    public List<String> getAllCategories(){
        return productService.getAllCategories();
    }
}
