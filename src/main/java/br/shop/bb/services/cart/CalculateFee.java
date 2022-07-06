package br.shop.bb.services.cart;

import br.shop.bb.model.Product;

import java.util.HashMap;

public class CalculateFee implements CalculateTotal {
    @Override
    public Double calculate(HashMap<Product, Integer> products) {
        products.forEach((product, integer) -> product.getTypeProduct().getFee());
        return 0.0;
    }
}
