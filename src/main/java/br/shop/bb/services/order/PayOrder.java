package br.shop.bb.services.order;

import br.shop.bb.model.Order;
import br.shop.bb.model.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayOrder {
    public void payOrder(Order order){
        setPaidPayment(order.getPayment());
        setTotaPayment(order.getPayment(), order.getCart().getTotal());
    }

    public void setPaidPayment(Payment payment){
        payment.setPaid(LocalDate.now());
    }

    public void setTotaPayment(Payment payment, double total){
        payment.setTotal(BigDecimal.valueOf(total));
    }
}
