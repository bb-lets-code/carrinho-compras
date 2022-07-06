package br.shop.bb.services.cart;

import br.shop.bb.interfaces.CalculateTotal;
import br.shop.bb.model.Product;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class CalculateFee implements CalculateTotal {
    @Override
    public Double calculate(HashMap<Product, Integer> products) {
        BigDecimal fee = new BigDecimal(0);
        for (Map.Entry<Product,Integer> product : products.entrySet()) {
            fee = fee.add(
                BigDecimal.valueOf(
                    product.getKey().getPrice() * 
                    product.getKey().getTypeProduct().getFee() * 
                    product.getValue()
                )
            );
        }
        MathContext mathContext = new MathContext(2);
        return fee.round(mathContext).doubleValue();
    }
}
