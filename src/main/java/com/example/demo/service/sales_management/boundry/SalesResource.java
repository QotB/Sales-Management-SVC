package com.example.demo.service.sales_management.boundry;


import com.example.demo.service.sales_management.control.SalesController;
import com.example.demo.service.sales_management.entity.SaleRequest;
import com.example.demo.service.sales_management.entity.SalesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesResource {

    @Autowired
    private SalesController salesService;

    @GetMapping
    public ResponseEntity<List<SalesModel>> getAllSales() {
        List<SalesModel> sales = salesService.getAllSales();
        return ResponseEntity.ok().body(sales);
    }

    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody SaleRequest saleRequest) {
        salesService.createSale(saleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{saleId}")
    public ResponseEntity<?> updateSale(@PathVariable String saleId, @RequestBody SaleRequest saleRequest) {
        salesService.updateSale(saleId, saleRequest);
        return ResponseEntity.ok().build();
    }

}
