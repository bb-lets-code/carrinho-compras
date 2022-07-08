package br.shop.bb.services.order;

import br.shop.bb.enums.PaymentType;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Order;
import br.shop.bb.model.Payment;
import br.shop.bb.model.PaymentMethod;

public class OrderBuilder implements Builder{
    private Cart cart;
    private int idClient;
    private PaymentMethod paymentMethod;
    private Payment payment;

    @Override
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void setPayment(Payment payment){
        this.payment = payment;
    }

    public Order getOrderResult(){
        return new Order(cart, cart.getIdClient(), paymentMethod, payment);
    }

}
