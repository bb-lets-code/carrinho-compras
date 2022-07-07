package br.shop.bb.main;

import br.shop.bb.enums.Installments;
import br.shop.bb.enums.PaymentType;
import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.*;
import br.shop.bb.services.cart.AddProduct;
import br.shop.bb.services.cart.RemoveProduct;
import br.shop.bb.services.order.OrderTemplate;
import br.shop.bb.services.order.OrderBuilder;
import br.shop.bb.services.order.PayOrder;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        Product product = new Product("Abacaxi", "Fruta", 10.0, TypeProduct.FOOD);
        Product product1 = new Product("Blusinha", "Fashion", 50.0, TypeProduct.CLOTHES);
        Client client = new Client();

        Cart cart = new Cart();
        AddProduct addProduct = new AddProduct();

        addProduct.addProducts(cart, product);
        addProduct.addProducts(cart, product);
        addProduct.addProducts(cart, product1);

        System.out.println(cart.getTotal());
        System.out.println("------");

        for (Map.Entry<Product, Integer> value : cart.getProducts().entrySet()) {
            System.out.println(value.getKey().getName() + " - " + value.getValue());
        }

        System.out.println("----------");

        RemoveProduct removeProduct = new RemoveProduct();
        removeProduct.removeProductCart(cart, product1);

        System.out.println(cart.getTotal());

        for (Map.Entry<Product, Integer> value : cart.getProducts().entrySet()) {
            System.out.println(value.getKey().getName() + " - " + value.getValue());
        }

        // Create Order in Close cart

        Card card = new Card();
        card.setNumber("4526412365478965");
        card.setFlag("Visa");
        card.setCode("452");

        PaymentMethod method = new PaymentMethod();
        method.setPaymentType(PaymentType.CREDITCARD);
        Payment payment = new CreditCard(card, Installments.TEN);
        System.out.println(payment.getPaid());
        OrderTemplate orderTem = new OrderTemplate();
        OrderBuilder builder = new OrderBuilder();

        orderTem.constructOrder(cart, method, payment, builder);

        Order order = builder.getOrderResult();

        PayOrder pay = new PayOrder();

        pay.payOrder(order);

        System.out.println(order.getPayment().getPaid());
        System.out.println(order.getPayment().getTotal());

    }
}
