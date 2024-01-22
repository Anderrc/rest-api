package com.andercdev.restandercdev.product.application;

import com.andercdev.restandercdev.product.domain.model.Product;
import com.andercdev.restandercdev.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {

    private final ProductRepository productRepository;

    @Autowired
    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(String name, String description, double price) {
        // Lógica de negocio para la creación de productos (validaciones, reglas de negocio, etc.)
        Product newProduct = new Product(name, description, price);
        return productRepository.save(newProduct);
    }
}
