package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.calculate.CalculateTotal;

public class RemoveProduct {
    public void removeProductCart(Cart cart, Product product){
        CalculateTotal calculateTotal = new CalculateTotal();

        if(cart.getProducts().containsKey(product)){
            cart.getProducts().remove(product);
        } else {
            System.out.println("Não existe esse produto no carrinho");
        }
        product.setPrice(product.getPrice() * -1.0);
        calculateTotal.calculate(cart, product);
    }
}
