package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class RemoveProduct {
    public void removeProductCart(Cart cart, Product product){
        if(cart.getProducts().containsKey(product)){
            cart.getProducts().remove(product);
        } else {
            System.out.println("Não existe esse produto no carrinho");
        }
    }
}
