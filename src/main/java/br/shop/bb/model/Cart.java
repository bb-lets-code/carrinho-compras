package br.shop.bb.model;

import java.util.HashMap;

public class Cart {
    private int idClient;
    private HashMap<Product, Integer> products;

    private double sales;

    private double shipping;

    private double fee;

    private double totalProducts;

    public Cart(){
        this.products = new HashMap<Product, Integer>();
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales += sales;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping += shipping;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee += fee;
    }

    public double getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(double totalProducts) {
        this.totalProducts += totalProducts;
    }

    public Double getTotal(){
        return this.fee + this.totalProducts + this.shipping - this.sales;
    }
}
