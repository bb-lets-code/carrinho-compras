package br.shop.bb.services.order;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Payment;
import br.shop.bb.model.PaymentMethod;

public interface Template {
    void constructOrder(Cart cart, PaymentMethod paymentMethod, Payment payment, Builder builder);
}
