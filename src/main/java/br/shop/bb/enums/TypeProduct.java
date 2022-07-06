package br.shop.bb.enums;



public enum TypeProduct {
    FOOD(0.1, 0.1, 0.15),
    DRINK(0.2,0.2, 0.2),

    CLOTHES(0.3,0.3, 0.3),
    ACCESSORIES(0.4,0.4, 0.4),
    OTHER(0.0,0.0,0.0);

    private final Double fee;
    private final Double shipping;
    private final Double sale;
    private TypeProduct(Double fee, Double shipping, Double sale){
        this.fee = fee;
        this.shipping = shipping;
        this.sale = sale;
    }

    public Double getFee(){
        return fee;
    }

    public Double getShipping(){
        return shipping;
    }

    public Double getSale(){
        return sale;
    }

}