package com.example.demo.service.sales_management.entity;

import com.example.demo.service.client_management.entity.ClientModel;
import com.example.demo.service.entity.SellerModel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "sales")
@Data
public class SalesModel {

    @Id
    private String id;

    private Date creationDate;

    private ClientModel client;

    private SellerModel seller;

    private List<SaleTransaction> transactions;

}
