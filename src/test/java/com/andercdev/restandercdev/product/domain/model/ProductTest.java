package com.andercdev.restandercdev.product.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void createProductWithNoId() {
        Product product = new Product("TestProduct", "TestDescription", 10.0);

        assertNull(product.getId());
        assertEquals("TestProduct", product.getName());
        assertEquals("TestDescription", product.getDescription());
        assertEquals(10.0, product.getPrice());
    }

    @Test
    void createProductWithSetId() {
        Product product = new Product("TestProduct", "TestDescription", 10.0);
        product.setId(1L);
        assertEquals(1L, product.getId());
        assertEquals("TestProduct", product.getName());
        assertEquals("TestDescription", product.getDescription());
        assertEquals(10.0, product.getPrice());
    }


    @Test
    void createProductWithId() {
        Product product = new Product(1L, "TestProduct", "TestDescription", 10.0);

        assertEquals(1L, product.getId());
        assertEquals("TestProduct", product.getName());
        assertEquals("TestDescription", product.getDescription());
        assertEquals(10.0, product.getPrice());
    }

    @Test
    void equalsMethodShouldReturnTrueForEqualProducts() {
        Product product1 = new Product(1L, "TestProduct", "TestDescription", 10.0);
        Product product2 = new Product(1L, "TestProduct", "TestDescription", 10.0);

        assertEquals(product1.getName(), product2.getName());
        assertNotEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void equalsMethodShouldReturnFalseForDifferentProducts() {
        Product product1 = new Product(1L, "TestProduct1", "TestDescription", 10.0);
        Product product2 = new Product(2L, "TestProduct2", "TestDescription", 20.0);

        assertFalse(product1.equals(product2) || product2.equals(product1));
        assertNotEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void toStringMethodShouldReturnExpectedString() {
        Product product = new Product(1L, "TestProduct", "TestDescription", 10.0);
        String expectedString = "Product{id=1, name='TestProduct', description='TestDescription', price=10.0}";

        assertEquals(expectedString, product.toString());
    }
}