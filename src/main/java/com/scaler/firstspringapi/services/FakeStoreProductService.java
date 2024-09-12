package com.scaler.firstspringapi.services;

import com.scaler.firstspringapi.dtos.FakeStoreServiceProductDTO;
import com.scaler.firstspringapi.models.Category;
import com.scaler.firstspringapi.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDTO(FakeStoreServiceProductDTO fakeStoreServiceProductDTO){
        Product product = new Product();
        product.setId(fakeStoreServiceProductDTO.getId());
        product.setTitle(fakeStoreServiceProductDTO.getTitle());
        product.setPrice(fakeStoreServiceProductDTO.getPrice());
        product.setImage(fakeStoreServiceProductDTO.getImage());
        product.setDescription(fakeStoreServiceProductDTO.getDescription());

        Category category = new Category();
        category.setDescription(fakeStoreServiceProductDTO.getCategory());

        product.setCategory(category);

        return product;
    }
    @Override
    public Product getProductById(Long id) {
        FakeStoreServiceProductDTO fakeStoreServiceProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreServiceProductDTO.class);
        if(fakeStoreServiceProductDTO == null){
            return null;
        }
        return convertFakeStoreProductDTO(fakeStoreServiceProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
