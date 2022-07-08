package br.shop.bb.services.order;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Payment;
import br.shop.bb.model.PaymentMethod;

public class OrderTemplate implements Template {
    @Override
    public void constructOrder(Cart cart, PaymentMethod paymentMethod, Payment payment, Builder builder) {
        builder.setCart(cart);
        builder.setPaymentMethod(paymentMethod);
        builder.setPayment(payment);
    }

}
