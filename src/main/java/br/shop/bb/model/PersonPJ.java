package br.shop.bb.model;

public class PersonPJ extends Person {
    private String cnpj;

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getCNPJ() {
        return this.cnpj;
    }
}