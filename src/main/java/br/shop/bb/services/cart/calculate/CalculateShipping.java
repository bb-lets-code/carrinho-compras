package br.shop.bb.services.cart.calculate;

import br.shop.bb.interfaces.Calculate;
import br.shop.bb.model.Product;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculateShipping implements Calculate {
    static CalculateShipping instance;

    public static CalculateShipping getInstance() {
        if(instance == null){
            instance = new CalculateShipping();
        }
        return instance;
    }
    private CalculateShipping(){}
    @Override
    public Double calculate(Product product){
        BigDecimal fee = new BigDecimal(0);

        fee = fee.add(
                BigDecimal.valueOf(
                        product.getPrice() *
                                product.getTypeProduct().getShipping()
                )
        );
        MathContext mathContext = new MathContext(2);
        return fee.round(mathContext).doubleValue();
    }

}
