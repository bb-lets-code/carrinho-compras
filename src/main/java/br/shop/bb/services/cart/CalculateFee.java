package br.shop.bb.services.cart;

import br.shop.bb.interfaces.CalculateTotal;
import br.shop.bb.model.Product;

import java.util.HashMap;

public class CalculateFee implements CalculateTotal {
    @Override
    public Double calculate(HashMap<Product, Integer> products) {
        Double total = 0.0;
        products.forEach((product, quantity) -> {
            total += product.getPrice() * quantity;
        });
        return  total;
    }
}
