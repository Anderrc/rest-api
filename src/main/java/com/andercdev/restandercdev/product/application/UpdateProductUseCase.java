package com.andercdev.restandercdev.product.application;

import com.andercdev.restandercdev.product.domain.model.Product;
import com.andercdev.restandercdev.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUseCase {

    private final ProductRepository productRepository;

    @Autowired
    public UpdateProductUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product execute(Long id, String name, String description, double price){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + id));

        existingProduct.setName(name);
        existingProduct.setDescription(description);
        existingProduct.setPrice(price);

        return productRepository.save(existingProduct);
    }
}
