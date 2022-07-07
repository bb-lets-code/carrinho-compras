package br.shop.bb.services.cart;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class CalculateTotal {
    public void calculate(Cart cart, Product product) {
        double price = product.getPrice();
        double fee = CalculateFee.getInstance().calculate(product);
        double sale = CalculateSale.getInstance().calculate(product);
        double shipping = CalculateShipping.getInstance().calculate(product);

        cart.setTotalProducts(price);
        cart.setFee(fee);
        cart.setSales(sale);
        cart.setShipping(shipping);
    }
}
