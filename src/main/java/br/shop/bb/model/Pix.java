package br.shop.bb.model;

public class Pix extends Payment{

    private String keyPixDestination;

    public Pix(PaymentMethod paymentMethod, String keyPixDestination){
        this.keyPixDestination = keyPixDestination;
    }

    public String getKeyPixDestination() {
        return keyPixDestination;
    }

    public void setKeyPixDestination(String keyPixDestination) {
        this.keyPixDestination = keyPixDestination;
    }
}
