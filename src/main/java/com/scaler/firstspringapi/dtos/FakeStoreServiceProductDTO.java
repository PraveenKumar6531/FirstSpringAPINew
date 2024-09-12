package com.scaler.firstspringapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreServiceProductDTO {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
