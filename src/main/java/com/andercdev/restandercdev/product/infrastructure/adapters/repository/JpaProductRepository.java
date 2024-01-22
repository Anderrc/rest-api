package com.andercdev.restandercdev.product.infrastructure.adapters.repository;

import com.andercdev.restandercdev.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
}