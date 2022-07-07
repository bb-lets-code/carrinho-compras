package br.shop.bb.model;

import br.shop.bb.annotations.ID;
import br.shop.bb.enums.TypeProduct;

import java.util.Objects;

//Product {idProduct, name, description, price, typeProduct(class, enum){......,...., etc}}
public class Product extends BaseModel<Integer> {
    @ID
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        Product that = (Product) o;
        return Objects.equals(name, that.name) && Objects.equals(idProduct, that.idProduct)
                && Objects.equals(description, that.description) && Objects.equals(unitaryPrice, that.unitaryPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idProduct, description, unitaryPrice);
    }

    @Override
    public String toString() {
        final StringBuilder s = new StringBuilder("Produto { ");
        s.append("Nome: ").append(name).append("; ");
        s.append("ID: ").append(idProduct).append("; ");
        s.append("Descrição: ").append(description).append("; ");
        s.append("Preço Unitário: R$ ").append(unitaryPrice).append("; ");
        s.append(" }");
        return s.toString();
    }
}