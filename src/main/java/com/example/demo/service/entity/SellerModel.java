package com.example.demo.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sellers")
@Data
public class SellerModel {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String mobile;
    private String email;
    private String address;

}
