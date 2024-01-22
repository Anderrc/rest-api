package com.andercdev.restandercdev.product.application;

import com.andercdev.restandercdev.product.domain.model.Product;
import com.andercdev.restandercdev.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductListUseCase {
    private final ProductRepository productRepository;

    @Autowired
    public GetProductListUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> execute() {
        // Lógica de negocio para obtener la lista de productos (puede incluir filtrado, ordenamiento, etc.)
        return productRepository.findAll();
    }
}
