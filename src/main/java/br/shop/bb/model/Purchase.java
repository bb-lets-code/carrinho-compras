package br.shop.bb.model;

import java.time.LocalDate;

import br.shop.bb.annotations.ID;

public class Purchase extends BaseModel<Integer> {

    @ID
    private Integer id;
    private LocalDate orderDate;
    private Client client;
    private Order order;



    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
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
        return "Purchase [client=" + client + ", id=" + id + ", order=" + order + ", orderDate=" + orderDate + "]";
    }
}
