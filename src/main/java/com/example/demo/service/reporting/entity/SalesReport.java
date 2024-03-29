package com.example.demo.service.reporting.entity;

import com.example.demo.service.entity.SellerModel;
import com.example.demo.service.product_management.entity.ProductModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SalesReport {

    private int totalNumberOfSales;

    private BigDecimal totalRevenue;

    private List<ProductModel> topSellingProducts;

    private List<SellerModel> topPerformingSellers;

}
