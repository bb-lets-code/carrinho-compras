package br.shop.bb.model;

import java.util.HashMap;

import br.shop.bb.annotations.ID;

public class Cart {
    @ID
    private int idCart;
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

    public int getIdCart() {
        return idCart;
    }
}
