package br.shop.bb.model;

public class Ticket extends Payment{

    private String barCode;

    public Ticket(String barCode){
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
