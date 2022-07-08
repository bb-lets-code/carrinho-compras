package br.shop.bb.enums;

import br.shop.bb.model.CreditCard;

public enum PaymentType {
    CREDITCARD("CreditCard"),
    TICKET("Ticket"),
    PIX("Pix");

    private final String instanceOf;

    PaymentType(String instanceOf){
        this.instanceOf = instanceOf;
    }

    public String getInstanceOf(){
        return instanceOf;
    }
}
