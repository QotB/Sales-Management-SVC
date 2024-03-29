package com.example.demo.service.product_management.control;


import com.example.demo.common.exceptions.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.product_management.entity.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public void createProduct(ProductModel product) {
        productRepository.save(product);
    }

    public void updateProduct(String productId, ProductModel product) {
        ProductModel existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        // Update existingProduct fields with the fields from product
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

}
