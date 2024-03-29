package com.example.demo.service.reporting.boundry;


import com.example.demo.service.reporting.control.ReportController;
import com.example.demo.service.reporting.entity.ClientReport;
import com.example.demo.service.reporting.entity.ProductReport;
import com.example.demo.service.reporting.entity.SalesReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/clients")
public class ReportResource {

    @Autowired
    private ReportController reportingService;

    @GetMapping("/sales")
    public ResponseEntity<SalesReport> generateSalesReport(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        SalesReport salesReport = reportingService.generateSalesReport(startDate, endDate);
        return ResponseEntity.ok().body(salesReport);
    }

    @GetMapping("/clients")
    public ResponseEntity<ClientReport> generateClientReport() {
        ClientReport clientReport = reportingService.generateClientReport();
        return ResponseEntity.ok().body(clientReport);
    }

    @GetMapping("/products")
    public ResponseEntity<ProductReport> generateProductReport() {
        ProductReport productReport = reportingService.generateProductReport();
        return ResponseEntity.ok().body(productReport);
    }

}
