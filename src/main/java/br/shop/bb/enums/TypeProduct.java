package br.shop.bb.enums;

import java.math.BigDecimal;

public enum TypeProduct {
    FOOD(0.1, 0.1),
    DRINK(0.2, 0.0),
    CLOTHES(0.3, 0.6),
    ACCESSORIES(0.4, 0.5),
    OTHER(0.5, 0.0);

    double discount;
    double fee;

    TypeProduct(double discount, double fee){
        this.discount = discount;
        this.fee = fee;
    }
    public double getDiscount() {
        return discount;
    }

    public double getFee() {
        return fee;
    }
}