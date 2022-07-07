package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.calculate.TotalCart;
import br.shop.bb.services.cart.calculate.recalculateEvent.CalculateEventManager;

public class AddProduct {
    public CalculateEventManager calculateEventManager;


    public AddProduct() {
        this.calculateEventManager = new CalculateEventManager("calculateCartTotal");
    }


    public void addProducts(Cart cart, Product product) {
        TotalCart calculateTotal = new TotalCart();

        if (cart.getProducts().containsKey(product)) {
            cart.getProducts().replace(product, cart.getProducts().get(product).intValue() + 1);
        } else {
            cart.getProducts().put(product, 1);
        }
        // calculateTotal.calculate(cart, product);
        calculateEventManager.notify("calculateCartTotal", cart, product);
    }
}
