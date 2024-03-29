package com.example.demo.service.sales_management.control;

import com.example.demo.common.exceptions.ResourceNotFoundException;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SaleRepository;
import com.example.demo.repository.SellerRepository;
import com.example.demo.service.client_management.entity.ClientModel;
import com.example.demo.service.entity.SellerModel;
import com.example.demo.service.product_management.entity.ProductModel;
import com.example.demo.service.sales_management.entity.SaleRequest;
import com.example.demo.service.sales_management.entity.SaleTransaction;
import com.example.demo.service.sales_management.entity.SalesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SalesController {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<SalesModel> getAllSales() {
        return saleRepository.findAll();
    }

    public void createSale(SaleRequest saleRequest) {
        SalesModel sale = new SalesModel();
        sale.setCreationDate(new Date());

        Optional<ClientModel> client = clientRepository.findById(saleRequest.getClientId());
        sale.setClient(client.get());

        Optional<SellerModel> seller = sellerRepository.findById(saleRequest.getSellerId());
        sale.setSeller(seller.get());

        List<SaleTransaction> transactions = new ArrayList<>();
        for (SaleTransaction transactionRequest : saleRequest.getTransactions()) {
            Optional<ProductModel> product = productRepository.findById(transactionRequest.getProduct().getId());
            SaleTransaction transaction = new SaleTransaction();
            transaction.setProduct(product.get());
            transaction.setQuantity(transactionRequest.getQuantity());
            transaction.setPrice(transactionRequest.getPrice());
            transaction.setSale(sale);
            transactions.add(transaction);
        }
        sale.setTransactions(transactions);

        saleRepository.save(sale);
    }

    public void updateSale(String saleId, SaleRequest saleRequest) {
        SalesModel existingSale = saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with id: " + saleId));

        existingSale.getTransactions().clear();
        existingSale.setTransactions(saleRequest.getTransactions());

        saleRepository.save(existingSale);
    }
}
