package com.example.demo.service.sales_management.entity;

import lombok.Data;

import java.util.List;

@Data
public class SaleRequest {

    private String clientId;

    private String sellerId;

    private List<SaleTransaction> transactions;

}
