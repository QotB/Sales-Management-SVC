package com.example.demo.service.reporting.entity;

import lombok.Data;

import java.util.Map;

@Data
public class ClientLocationStatistics {

    private Map<String, Integer> countryWiseClientCount;
}
