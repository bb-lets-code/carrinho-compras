package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class UpdateQtProductCart {
    public void updateProductCart(Cart cart, Product product, int quantity){
        if(cart.getProducts().containsValue(product)){
            cart.getProducts().replace(product, quantity);
        } else {
            System.out.println("Não existe esse produto no carrinho");
        }
    }
}
