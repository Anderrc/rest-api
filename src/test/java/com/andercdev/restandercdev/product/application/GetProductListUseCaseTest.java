package com.andercdev.restandercdev.product.application;

import com.andercdev.restandercdev.product.domain.model.Product;
import com.andercdev.restandercdev.product.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetProductListUseCaseTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    GetProductListUseCase getProductListUseCase;

    @Test
    void execute() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(1L, "Raton", "MX", 123.1));
        productList.add(new Product(2L, "Raton", "MX2", 123.1));
        productList.add(new Product(3L, "Raton", "MX3", 123.1));
        productList.add(new Product(4L, "Raton", "MX4", 123.1));

        Mockito.when(productRepository.findAll()).thenReturn(productList);
        List<Product> response = getProductListUseCase.execute();
        assertEquals(response, productList);
        assertEquals(response.size(), productList.size());
    }
}