package com.example.demo.service.reporting.entity;

import com.example.demo.service.client_management.entity.ClientModel;
import com.example.demo.service.entity.SellerModel;
import com.example.demo.service.product_management.entity.ProductModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ClientReport {

    private int totalNumberOfClients;

    private List<ClientModel> topSpendingClients;

    private List<ClientActivity> clientActivity;

    private ClientLocationStatistics clientLocationStatistics;

}
