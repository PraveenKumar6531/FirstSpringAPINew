package com.scaler.firstspringapi.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private Category category;
}
