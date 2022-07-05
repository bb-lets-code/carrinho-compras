package br.shop.bb.model;

import java.util.HashMap;

public class Cart {
    private int idClient;
    private HashMap<Product, Integer> products;

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
