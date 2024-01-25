package com.andercdev.restandercdev.product.application;

import com.andercdev.restandercdev.product.domain.model.Product;
import com.andercdev.restandercdev.product.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    CreateProductUseCase createProductUseCase;

    @Test
    void execute() {
        Product product = new Product(1L, "Producto", "desc", 123.1);

        // Utiliza any() en lugar de eq() para hacer la simulación más flexible
        when(productRepository.save(any()))
                .thenReturn(product);

        Product result = createProductUseCase.execute("Producto", "desc", 123.1);
        assertEquals(result, product);
    }
}