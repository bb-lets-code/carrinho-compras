package br.shop.bb.model;

import br.shop.bb.enums.PaymentType;

public class PaymentMethod {
    private PaymentType paymentType;

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
