package com.andercdev.restandercdev.product.application;

import com.andercdev.restandercdev.product.domain.model.Product;
import com.andercdev.restandercdev.product.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductByIdUseCase {

    private static Logger logger = LoggerFactory.getLogger(GetProductByIdUseCase.class);

    private final ProductRepository productRepository;

    @Autowired
    public GetProductByIdUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> execute(Long id) {
        logger.info("ID " + id);
        logger.info("ID 2" + id);
        return productRepository.findById(id);
    }
}
