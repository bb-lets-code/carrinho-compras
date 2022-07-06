package br.shop.bb.enums;



public enum TypeProduct {
    FOOD(0.1, 0.1, 0.1),
    DRINK(0.2,0.2, 0.2),

    CLOTHES(0.3,0.3, 0.3),
    ACCESSORIES(0.4,0.4, 0.4),
    OTHER(0.0,0.0,0.0);

    private final Double fee;
    private final Double frete;
    private final Double sale;
    private TypeProduct(Double fee, Double frete, Double sale){
        this.fee = fee;
        this.frete = frete;
        this.sale = sale;
    }

    public Double getFee(){
        return fee;
    }

    public Double getFrete(){
        return frete;
    }

    public Double getSale(){
        return sale;
    }

}