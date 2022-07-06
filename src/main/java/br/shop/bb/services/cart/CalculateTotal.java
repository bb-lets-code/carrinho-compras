package br.shop.bb.services.cart;

import br.shop.bb.model.Product;

import java.util.HashMap;

public interface CalculateTotal {
    Double calculate(HashMap<Product, Integer> products);
}

