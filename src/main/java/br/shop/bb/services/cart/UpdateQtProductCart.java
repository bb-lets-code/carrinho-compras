package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.calculate.recalculateEvent.listeners.RecalculateListener;
import br.shop.bb.services.cart.calculate.recalculateEvent.publisher.CalculateEventManager;

public class UpdateQtProductCart {
    private CalculateEventManager calculateEventManager;

    public UpdateQtProductCart() {
        this.calculateEventManager = new CalculateEventManager("calculateCartTotal");
        this.calculateEventManager.subscribe("calculateCartTotal", new RecalculateListener());
    }
    public void updateProductCart(Cart cart, Product product, int quantity){
        if(cart.getProducts().containsValue(product)){
            cart.getProducts().replace(product, quantity);
        } else {
            System.out.println("Não existe esse produto no carrinho");
        }
    }
}
