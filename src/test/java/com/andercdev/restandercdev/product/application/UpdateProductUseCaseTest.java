package com.andercdev.restandercdev.product.application;

import com.andercdev.restandercdev.product.domain.model.Product;
import com.andercdev.restandercdev.product.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UpdateProductUseCaseTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    UpdateProductUseCase updateProductUseCase;

    @Test
    void executeTrowIllegalArgumentException() {
        Product product = new Product(1L, "Mouse", "MX", 123.1);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.empty());

        try {
            updateProductUseCase.execute(1L,"Persona", "Persona", 123.1);
        }catch (IllegalArgumentException illegalArgumentException) {
            assertEquals("Product not found with ID: " + 1L, illegalArgumentException.getMessage());
        }
    }

    @Test
    void execute() {
        Product product = new Product(1L, "Mouse", "MX", 123.1);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(any())).thenReturn(product);

        Product productUpdated = updateProductUseCase.execute(1L,"Persona", "Persona", 123.1);
        assertEquals("Persona", productUpdated.getName());
    }

}