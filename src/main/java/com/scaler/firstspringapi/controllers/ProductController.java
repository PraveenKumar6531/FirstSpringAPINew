package com.scaler.firstspringapi.controllers;

import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import com.scaler.firstspringapi.models.Category;
import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("selfProductService") ProductService productService){
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

    @GetMapping("/cat/{categoryId}")
    public List<Product> getAllProducts(@PathVariable("categoryId")  Long categoryId){
        return productService.getAllProductsByCategory(categoryId);
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
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
