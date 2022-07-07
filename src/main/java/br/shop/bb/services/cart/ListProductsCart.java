package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

import java.util.Map;

public class ListProductsCart {
    public void listProductsCart(Cart cart){
        System.out.println("=======PRODUTOS========");
        for (Map.Entry<Product, Integer> value : cart.getProducts().entrySet()) {
            System.out.println(value.getKey() + " Quantidade: " + value.getValue());
        }
        System.out.println("=======================");
    }
}
