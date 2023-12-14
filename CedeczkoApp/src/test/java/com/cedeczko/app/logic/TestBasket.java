package com.cedeczko.app.logic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestBasket {

    @Test
    public void testAddProduct() {
        Basket basket = new Basket(new ArrayList<>());
        basket.addProduct("Inception");
        basket.addProduct("The Shawshank Redemption");

        List<String> expectedProducts = Arrays.asList("Inception", "The Shawshank Redemption");
        assertEquals(expectedProducts, basket.getProducts());
    }

    @Test
    public void testRemoveProduct() {
        Basket basket = new Basket(new ArrayList<>());
        basket.addProduct("Inception");
        basket.addProduct("The Shawshank Redemption");
        basket.addProduct("The Godfather");

        basket.removeProduct("The Shawshank Redemption");

        List<String> expectedProducts = Arrays.asList("Inception", "The Godfather");
        assertEquals(expectedProducts, basket.getProducts());
    }

    @Test
    public void testGetProducts() {
        Basket basket = new Basket(new ArrayList<>());
        basket.addProduct("Inception");
        basket.addProduct("The Shawshank Redemption");

        List<String> actualProducts = basket.getProducts();
        List<String> expectedProducts = Arrays.asList("Inception", "The Shawshank Redemption");

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void testSetProducts() {
        Basket basket = new Basket(new ArrayList<>());
        basket.addProduct("Inception");
        basket.addProduct("The Shawshank Redemption");

        List<String> newProducts = Arrays.asList("The Godfather", "Pulp Fiction");
        basket.setProducts(newProducts);

        assertEquals(newProducts, basket.getProducts());
    }
}
