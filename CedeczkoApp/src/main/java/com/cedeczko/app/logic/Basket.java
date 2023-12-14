package com.cedeczko.app.logic;

import java.util.*;

public class Basket {
    private List<String> products;

    public Basket(List<String> given_products) {
      set_products(given_products);
    }

    //nwm czy się przyda, ale zostawiam
    public void set_products(List<String> new_products) {
        this.products = new_products;
    }

    public List<String> get_products(){
        return this.products;
    }

    public void add_product(String product) {
        products.add(product);
    }

    public void remove_product(String product) {
        products.remove(product);
    }
}