package com.example.demo.repository;


import com.example.demo.service.sales_management.entity.SalesModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SaleRepository extends MongoRepository<SalesModel, String> {

    List<SalesModel> findByCreationDateBetween(Date date1, Date date2);
}
