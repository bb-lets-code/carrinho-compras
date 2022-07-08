package br.shop.bb.services.order;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Payment;
import br.shop.bb.model.PaymentMethod;

public interface Builder {
    void setCart(Cart cart);
    void setPaymentMethod(PaymentMethod paymentMethod);
    void setPayment(Payment payment);
}
