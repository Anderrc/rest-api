package com.andercdev.restandercdev.product.infrastructure.adapters.controllers;

import com.andercdev.restandercdev.product.application.CreateProductUseCase;
import com.andercdev.restandercdev.product.application.GetProductByIdUseCase;
import com.andercdev.restandercdev.product.application.GetProductListUseCase;
import com.andercdev.restandercdev.product.application.UpdateProductUseCase;
import com.andercdev.restandercdev.product.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    GetProductListUseCase getProductListUseCase;

    @Mock
    GetProductByIdUseCase getProductByIdUseCase;

    @Mock
    UpdateProductUseCase updateProductUseCase;

    @Mock
    CreateProductUseCase createProductUseCase;

    @InjectMocks
    ProductController productController;

    @Test
    void createProduct() {

        Product product = new Product(1L, "name", "21", 123.0);
        Mockito.when(createProductUseCase.execute("name", "21", 123.0)).thenReturn(product);
        ProductController.ProductRequestDTO productRequestDTO = new ProductController.ProductRequestDTO("name", "21",123.0);

        ResponseEntity<Product> response = productController.createProduct(productRequestDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
    }
    @Test
    void getProductList() {
        // Configuración del servicio mock
        List<Product> productList = Arrays.asList(new Product (1L,"name", "Desc", 10.0), new Product(1L,"name", "Desc", 10.0));
        Mockito.when(getProductListUseCase.execute()).thenReturn(productList);

        // Llamada al controlador y verificación
        ResponseEntity<List<Product>> response = productController.getProductList();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productList, response.getBody());
    }

    @Test
    void getProductById() {

        Optional<Product> product = Optional.of(new Product(1L, "Producto", "Descripcion", 123.0));
        Mockito.when(getProductByIdUseCase.execute(1L)).thenReturn(product);

        ResponseEntity<Optional<Product>> response = productController.getProductById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void updateProduct() {

        Product product = new Product(1L, "Producto", "Descripcion", 123.0);
        Mockito.when(updateProductUseCase.execute(1L,"Producto 2", "Descripcion 2", 123.0)).thenReturn(product);
        ProductController.ProductRequestDTO productRequestDTO = new ProductController.ProductRequestDTO("Producto 2", "Descripcion 2", 123.0);

        ResponseEntity<Product> response = productController.updateProduct(1L,productRequestDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }
}