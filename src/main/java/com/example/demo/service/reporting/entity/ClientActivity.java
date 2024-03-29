package com.example.demo.service.reporting.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientActivity {

    private Long clientId;

    private int numberOfPurchases;

    private BigDecimal totalSpent;
}
