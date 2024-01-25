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

@ExtendWith(MockitoExtension.class)
class GetProductByIdUseCaseTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    GetProductByIdUseCase getProductByIdUseCase;

    @Test
    void execute() {
        Product product = new Product(1L,"Product","MX", 123.1);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> result = getProductByIdUseCase.execute(1L);
        assertTrue(result.isPresent());
        assertEquals(product, result.get());
        assertEquals(1L, result.get().getId());
        assertEquals("Product", result.get().getName());
        assertEquals("MX", result.get().getDescription());
    }
}