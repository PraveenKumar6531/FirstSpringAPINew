package com.scaler.firstspringapi.services;

import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import com.scaler.firstspringapi.models.Category;
import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.repositories.CategoryRepository;
import com.scaler.firstspringapi.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findProductById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product Not found id = ",id);
        }

        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getAllProductsByCategory(Long id) {
        return productRepository.getProductsByTitleSQL(id);
    }

    @Override
    public ResponseEntity<Product> replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public ResponseEntity<List<Product>> getCategoryByName(String name) {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
//        if(category.getId() == null){
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }
//        else{
//            Optional<Category> newCategory = categoryRepository.findById(category.getId());
//            product.setCategory(newCategory.get());
//        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
