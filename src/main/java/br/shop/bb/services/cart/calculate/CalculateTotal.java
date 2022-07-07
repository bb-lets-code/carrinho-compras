package br.shop.bb.services.cart.calculate;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class CalculateTotal {
    public void calculate(Cart cart, Product product) {
        cart.setTotalProducts(product.getPrice());
        cart.setFee(CalculateFee.getInstance().calculate(product));
        cart.setSales(CalculateSale.getInstance().calculate(product));
        cart.setShipping(CalculateShipping.getInstance().calculate(product));
    }
}
