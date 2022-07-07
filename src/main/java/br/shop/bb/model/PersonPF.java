package br.shop.bb.model;

public class PersonPF extends Person {
    private String cpf;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    public String getID(){
        return cpf;
    }
} 
