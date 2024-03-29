package com.example.demo.service.client_management.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "clients")
@Data
public class ClientModel {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String mobile;
    private String email;
    private String address;

}
