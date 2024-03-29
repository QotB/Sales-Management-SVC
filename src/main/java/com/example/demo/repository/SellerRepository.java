package com.example.demo.repository;

import com.example.demo.service.client_management.entity.ClientModel;
import com.example.demo.service.entity.SellerModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends MongoRepository<SellerModel, String> {
}
