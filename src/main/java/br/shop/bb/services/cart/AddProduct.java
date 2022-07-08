package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.calculate.recalculateEvent.listeners.RecalculateListener;
import br.shop.bb.services.cart.calculate.recalculateEvent.publisher.CalculateEventManager;

public class AddProduct {
    private CalculateEventManager calculateEventManager;


    public AddProduct() {
        this.calculateEventManager = new CalculateEventManager("calculateCartTotal");
        this.calculateEventManager.subscribe("calculateCartTotal", new RecalculateListener());
    }


    public void addProducts(Cart cart, Product product) {
        if (cart.getProducts().containsKey(product)) {
            cart.getProducts().replace(product, cart.getProducts().get(product).intValue() + 1);
        } else {
            cart.getProducts().put(product, 1);
        }
        calculateEventManager.notify("calculateCartTotal", cart, product);
    }
}
