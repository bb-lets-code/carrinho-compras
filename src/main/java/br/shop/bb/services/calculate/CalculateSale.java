package br.shop.bb.services.calculate;

import br.shop.bb.interfaces.Calculate;
import br.shop.bb.model.Product;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculateSale implements Calculate {

    static CalculateSale instance;

    public static CalculateSale getInstance() {
        if(instance == null){
            instance = new CalculateSale();
        }
        return instance;
    }

    private CalculateSale(){}
    @Override
    public Double calculate(Product product) {
        BigDecimal fee = new BigDecimal(0);

        fee = fee.add(
                BigDecimal.valueOf(
                        product.getPrice() *
                                product.getTypeProduct().getSale()
                )
        );
        MathContext mathContext = new MathContext(2);
        return fee.round(mathContext).doubleValue();
    }
}
