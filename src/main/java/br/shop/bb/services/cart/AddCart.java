package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class AddCart {
    public void addProducts(Cart cart, Product product) {
        if(cart.getProducts().containsValue(product)){
            cart.getProducts().replace(product, cart.getProducts().get(product).intValue() + 1);
        } else {
            cart.getProducts().put(product, 1);
        }
    }
}
