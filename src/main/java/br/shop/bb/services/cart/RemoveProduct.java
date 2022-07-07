package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.calculate.TotalCart;
import br.shop.bb.services.cart.calculate.recalculateEvent.listeners.RecalculateListener;
import br.shop.bb.services.cart.calculate.recalculateEvent.publisher.CalculateEventManager;

public class RemoveProduct {
    private CalculateEventManager calculateEventManager;


    public RemoveProduct() {
        this.calculateEventManager = new CalculateEventManager("calculateCartTotal");
        this.calculateEventManager.subscribe("calculateCartTotal",new RecalculateListener());
    }


    public void removeProductCart(Cart cart, Product product){
        TotalCart calculateTotal = new TotalCart();

        if(cart.getProducts().containsKey(product)){
            cart.getProducts().remove(product);
        } else {
            System.out.println("Não existe esse produto no carrinho");
        }
        product.setPrice(product.getPrice() * -1.0);
        calculateTotal.calculate(cart, product);
    }
}
