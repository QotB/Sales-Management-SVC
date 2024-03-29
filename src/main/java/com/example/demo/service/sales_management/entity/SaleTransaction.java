package com.example.demo.service.sales_management.entity;

import com.example.demo.service.product_management.entity.ProductModel;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SaleTransaction {


    @Id
    private String id;

    private SalesModel sale;

    private ProductModel product;

    private Integer quantity;

    private Double price;
}
