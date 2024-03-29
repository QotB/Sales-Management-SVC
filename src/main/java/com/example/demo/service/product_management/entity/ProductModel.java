package com.example.demo.service.product_management.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "products")
@Data
public class ProductModel {

    @Id
    private String id;
    private String name;
    private String description;
    private String category;
    private Date creationDate;
    private Long quantity;
    private Double price;
}
