package br.shop.bb.services.cart;

import java.util.Map;

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
        if(cart.getProducts().containsKey(product)){
            for (Map.Entry<Product, Integer> value : cart.getProducts().entrySet()) {
                if(value.getKey().equals(product)){
                    int diference = value.getValue() - quantity;
                    if(value.getValue()> quantity){
                        RemoveProduct removeProduct = new RemoveProduct();
                        for (int i = 0; i < diference; i++) {
                            removeProduct.removeProductCart(cart, product);
                        }
                    }else{
                        AddProduct addProduct = new AddProduct();
                        for (int i = 0; i < Math.abs(diference +1) ; i++) {
                            addProduct.addProducts(cart, product);
                        }
                    }
                    break;
                }
            }

            cart.getProducts().replace(product, quantity);


            this.calculateEventManager.notify("calculateCartTotal", cart, product);
        } else {
            System.out.println("Não existe esse produto no carrinho");
        }
    }
}
