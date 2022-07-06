package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class CalculateTotal {
    public static Double calculate(Cart cart, Product product) {
        // TEMPLATE METHOD

        cart.setTotalProducts(product.getPrice());
        cart.setFee(CalculateFee.getInstance().calculate(product));
        cart.setSales(CalculateSale.getInstance().calculate(product));
        cart.setShipping(CalculateShipping.getInstance().calculate(product));

        return null;
    }
}
