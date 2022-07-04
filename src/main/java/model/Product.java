package model;


//Product {idProduct, name, description, price, typeProduct(class, enum){......,...., etc}}
public class Product {

    public enum TypeProduct {
        FOOD,
        DRINK,
        CLOTHES,
        ACCESSORIES,
        OTHER
    }

    private int idProduct;
    private String name;
    private String description;
    private Double unitaryPrice;
    
    private TypeProduct typeProduct;
    public Product(String name, String description, Double price, TypeProduct typeProduct) {
        this.name = name;
        this.description = description;
        this.unitaryPrice = price;
        this.typeProduct = typeProduct;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return unitaryPrice;
    }
    public void setPrice(Double price) {
        this.unitaryPrice = price;
    }
    public TypeProduct getTypeProduct() {
        return typeProduct;
    }
    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }    
}