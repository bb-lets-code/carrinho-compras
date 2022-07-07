package br.shop.bb.enums;

public enum Installments {
    ONE(1),
    TWO(2),
    TREE(3),
    FOR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private final int installments;

    Installments(int installments){
        this.installments = installments;
    }

    public int getInstallments(){
        return installments;
    }

}
