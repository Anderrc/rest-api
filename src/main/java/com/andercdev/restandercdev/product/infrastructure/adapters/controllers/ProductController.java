package com.andercdev.restandercdev.product.infrastructure.adapters.controllers;


import com.andercdev.restandercdev.product.application.CreateProductUseCase;
import com.andercdev.restandercdev.product.application.GetProductByIdUseCase;
import com.andercdev.restandercdev.product.application.GetProductListUseCase;
import com.andercdev.restandercdev.product.application.UpdateProductUseCase;
import com.andercdev.restandercdev.product.domain.model .Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    private final GetProductListUseCase getProductListUseCase;

    private final GetProductByIdUseCase getProductByIdUseCase;

    private final UpdateProductUseCase updateProductUseCase;

    @Autowired
    public ProductController(CreateProductUseCase createProductUseCase, GetProductListUseCase getProductListUseCase, GetProductByIdUseCase getProductByIdUseCase, UpdateProductUseCase updateProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.getProductListUseCase = getProductListUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO productRequestDTO)  {
            Product newProduct = createProductUseCase.execute(productRequestDTO.getName(), productRequestDTO.getDescription(), productRequestDTO.getPrice());
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProductList() {
        List<Product> productList = getProductListUseCase.execute();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        Optional<Product> productList = getProductByIdUseCase.execute(id);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody ProductRequestDTO productRequestDTO){
        Product productToUpdate = updateProductUseCase.execute(id, productRequestDTO.getName(), productRequestDTO.getDescription(), productRequestDTO.getPrice());
        return new ResponseEntity<>(productToUpdate, HttpStatus.OK);
    }

    // Puedes agregar más métodos para otras operaciones CRUD o consultas según tus necesidades

    // Clase DTO para la solicitud de creación de producto
    public static class ProductRequestDTO {
        private String name;
        private String description;
        private double price;

        public ProductRequestDTO(String name, String description, double price){
            this.name = name;
            this.description = description;
            this.price = price;

        }

        public String getName() {
            return this.name;
        }

        public String getDescription() {
            return this.description;
        }

        public double getPrice() {
            return this.price;
        }

    }
}
