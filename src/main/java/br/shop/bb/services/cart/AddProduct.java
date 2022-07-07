package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.calculate.CalculateTotal;

public class AddProduct {
    public void addProducts(Cart cart, Product product) {
        CalculateTotal calculateTotal = new CalculateTotal();

        if (cart.getProducts().containsKey(product)) {
            cart.getProducts().replace(product, cart.getProducts().get(product).intValue() + 1);
        } else {
            cart.getProducts().put(product, 1);
        }
        calculateTotal.calculate(cart, product);
    }
}
