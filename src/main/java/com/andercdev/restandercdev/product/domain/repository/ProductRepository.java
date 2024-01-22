package com.andercdev.restandercdev.product.domain.repository;

import com.andercdev.restandercdev.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
