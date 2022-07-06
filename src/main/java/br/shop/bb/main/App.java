package br.shop.bb.main;

import java.util.HashMap;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Client;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.CalculateFee;

public class App {
    public static void main(String[] args) {
        Product product = new Product("Abacaxi", "Fruta", 3.0, TypeProduct.FOOD);
        Product product2 = new Product("Abacaxi", "Fruta", 3.0, TypeProduct.CLOTHES);
        Product product3 = new Product("Abacaxi", "Fruta", 3.0, TypeProduct.FOOD);
        Client client = new Client();

        HashMap<Product, Integer> products = new HashMap<>();
        // products.put(product, 2);
        products.put(product2, 1);
        // products.put(product3, 1);

        CalculateFee calculateFee = new CalculateFee();
        Double fee = calculateFee.calculate(products);
        System.out.println(fee);
    }
}
