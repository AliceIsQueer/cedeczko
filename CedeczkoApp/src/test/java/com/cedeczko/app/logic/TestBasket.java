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
        basket.add_product("Inception");
        basket.add_product("The Shawshank Redemption");

        List<String> expectedProducts = Arrays.asList("Inception", "The Shawshank Redemption");
        assertEquals(expectedProducts, basket.get_products());
    }

    @Test
    public void testRemoveProduct() {
        Basket basket = new Basket(new ArrayList<>());
        basket.add_product("Inception");
        basket.add_product("The Shawshank Redemption");
        basket.add_product("The Godfather");

        basket.remove_product("The Shawshank Redemption");

        List<String> expectedProducts = Arrays.asList("Inception", "The Godfather");
        assertEquals(expectedProducts, basket.get_products());
    }

    @Test
    public void testGetProducts() {
        Basket basket = new Basket(new ArrayList<>());
        basket.add_product("Inception");
        basket.add_product("The Shawshank Redemption");

        List<String> actualProducts = basket.get_products();
        List<String> expectedProducts = Arrays.asList("Inception", "The Shawshank Redemption");

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void testSetProducts() {
        Basket basket = new Basket(new ArrayList<>());
        basket.add_product("Inception");
        basket.add_product("The Shawshank Redemption");

        List<String> newProducts = Arrays.asList("The Godfather", "Pulp Fiction");
        basket.set_products(newProducts);

        assertEquals(newProducts, basket.get_products());
    }
}
