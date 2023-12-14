package com.cedeczko.app.logic;

import java.util.*;

public class Basket {
    private List<String> products;

    public Basket(List<String> given_products) {
      setProducts(given_products);
    }

    //nwm czy się przyda, ale zostawiam
    public void setProducts(List<String> new_products) {
        this.products = new_products;
    }

    public List<String> getProducts(){
        return this.products;
    }

    public void addProduct(String product) {
        products.add(product);
    }

    public void removeProduct(String product) {
        products.remove(product);
    }
}