package br.shop.bb.model;

public class Order {
    private Cart cart;
    private int idClient;
    private PaymentMethod paymentMethod;
    private Payment payment;

    public Order(){};

    public Order(Cart cart, int idClient, PaymentMethod paymentMethod, Payment payment){
        this.cart = cart;
        this.idClient = idClient;
        this.paymentMethod = paymentMethod;
        this.payment = payment;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
