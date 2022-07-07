package br.shop.bb.services.cart.calculate.recalculateEvent.listeners;

import br.shop.bb.interfaces.EventListener;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.calculate.TotalCart;

public class RecalculateListener implements EventListener {
    

    @Override
    public void recalculate(String eventType, Cart cart, Product product) {
        
        TotalCart calculateTotal = new TotalCart();
        calculateTotal.calculate(cart, product);
        
    }

    
}