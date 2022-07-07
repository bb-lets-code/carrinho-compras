package br.shop.bb.services.cart.calculate;

import br.shop.bb.interfaces.Calculate;
import br.shop.bb.model.Product;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculateFee implements Calculate {
    static CalculateFee instance;

    public static CalculateFee getInstance() {
        if(instance == null){
            instance = new CalculateFee();
        }
        return instance;
    }

    private CalculateFee(){}
    @Override
    public Double calculate(Product product){
        BigDecimal fee = new BigDecimal(0);

        fee = fee.add(
                BigDecimal.valueOf(
                        product.getPrice() *
                                product.getTypeProduct().getFee()
                )
        );
        MathContext mathContext = new MathContext(2);
        return fee.round(mathContext).doubleValue();
    }
}
