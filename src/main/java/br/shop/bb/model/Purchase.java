package br.shop.bb.model;

import java.time.LocalDate;

import br.shop.bb.annotations.ID;

public class Purchase extends BaseModel<Integer> {

    @ID
    private Integer id;
    private LocalDate orderDate;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    @Override
    public String toString() {
        return "Purchase [id=" + id + ", orderDate=" + orderDate + "]";
    }
}
