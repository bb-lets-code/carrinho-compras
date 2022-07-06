package br.shop.bb.main;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Client;
import br.shop.bb.model.Product;

public class App {
    public static void main(String[] args) {
        Product product = new Product("Abacaxi", "Fruta", 3.0, TypeProduct.FOOD);
        Client client = new Client();
    }
}
