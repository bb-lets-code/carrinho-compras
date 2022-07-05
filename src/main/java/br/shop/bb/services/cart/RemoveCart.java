package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class RemoveCart {
    public void removeProductCart(Cart cart, Product product){
        if(cart.getProducts().containsValue(product)){
            cart.getProducts().remove(product);
        } else {
            System.out.println("Não existe esse produto no carrinho");
        }
    }
}
