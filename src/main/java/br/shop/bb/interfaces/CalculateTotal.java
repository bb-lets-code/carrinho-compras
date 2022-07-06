package br.shop.bb.interfaces;

import br.shop.bb.model.Product;

import java.util.HashMap;

public interface CalculateTotal {
    Double calculate(HashMap<Product, Integer> products);
}

