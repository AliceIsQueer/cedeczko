package com.cedeczko.app.logic;

import java.util.*;

public class Basket {
    private static Basket instance;
    private List<String[]> products;
    int products_number;
    float value;

    private Basket() {
      this.products = new ArrayList<String[]>();
      this.products_number = 0;
      this.value = 0;
    }

    public static synchronized Basket getInstance() {
      if (instance == null) {
          instance = new Basket();
      }
      return instance;
    }

    public void setProducts(List<String[]> newProducts) {
        products.clear();
        products.addAll(newProducts);
        products_number = newProducts.size();
        value = 0;
        for (String[] product : products) {
          value += Float.parseFloat(product[4]);
        }
    }

    public void setProductsNumber(int number){
        products_number = number;
    }

    public void setValue(int given_value){
        value = given_value;
    }

    public List<String[]> getProducts(){
        return this.products;
    }

    public int getProductsNumber(){
        return this.products_number;
    }

    public float getValue(){
        return this.value;
    }

    public void addProduct(String[] product) {
        products.add(product);
        products_number += 1;
        value += Float.parseFloat(product[4]);
    }

    public void removeProduct(String title, String date, float price) {
        String[] product_to_remove = null;
        for (String[] product : products) {
          if (product[0].equals(title) && product[3].equals(date) && Float.parseFloat(product[4]) == price) {
            product_to_remove = product;
            break;
          }
        }

        if (product_to_remove != null) {
          products.remove(product_to_remove);
          products_number -= 1;
          value -= Float.parseFloat(product_to_remove[4]);
        }
        
    }

    public void removeAllProducts() {
        products.clear();
        products_number = 0;
        value = 0;
    }
}