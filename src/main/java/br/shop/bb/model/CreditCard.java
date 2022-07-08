package br.shop.bb.model;

import br.shop.bb.enums.Installments;

public class CreditCard extends Payment{

    private Card card;
    private Installments installments;
    private Double installmentValue;

    public CreditCard(Card card, Installments installments){
        super();
        this.card = card;
        this.installments = installments;
    }

    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public Double getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(Double installmentValue) {
        this.installmentValue = installmentValue;
    }
}
