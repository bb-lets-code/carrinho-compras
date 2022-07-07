package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

import java.util.Map;

public class ViewCart {
    public void listProductsCart(Cart cart){
        System.out.println("PRODUTOS DO CARRINHO");
        for (Map.Entry<Product, Integer> value : cart.getProducts().entrySet()) {
            System.out.println(value.getKey() +
                    " Quantidade: " + value.getValue() +
                    " Total Produto: " + value.getKey().getPrice() * value.getValue());

        }
        System.out.println("--------------------");
    }

    public void printCart(Cart cart){
        System.out.println("=======CARRINHO=======");
        listProductsCart(cart);
        System.out.println("Total dos produtos: R$" + cart.getTotalProducts());
        System.out.println("Taxas cobradas: R$" + cart.getFee());
        System.out.println("Frete: R$" + cart.getShipping());
        System.out.println("Promoção: -R$" + cart.getSales());
        System.out.println("Total do carrinho: R$" + cart.getTotal());
    }
}
