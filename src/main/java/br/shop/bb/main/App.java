package br.shop.bb.main;

import java.time.LocalDate;
import java.util.Set;

import br.shop.bb.enums.Installments;
import br.shop.bb.enums.PaymentType;
import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Card;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Client;
import br.shop.bb.model.CreditCard;
import br.shop.bb.model.Order;
import br.shop.bb.model.Payment;
import br.shop.bb.model.PaymentMethod;
import br.shop.bb.model.PersonPF;
import br.shop.bb.model.Product;
import br.shop.bb.model.Purchase;
import br.shop.bb.repository.product.MemoryProductRepository;
import br.shop.bb.repository.purchase.MemoryPurchaseRepository;
import br.shop.bb.services.application.InitApplication;
import br.shop.bb.services.cart.AddProduct;
import br.shop.bb.services.cart.RemoveProduct;
import br.shop.bb.services.cart.UpdateQtProductCart;
import br.shop.bb.services.cart.ViewCart;
import br.shop.bb.services.order.OrderBuilder;
import br.shop.bb.services.order.OrderTemplate;
import br.shop.bb.services.order.PayOrder;

public class App {
    public static void main(String[] args) {
        Cart cart = new Cart();
        ViewCart viewCart = new ViewCart();
        AddProduct addProduct = new AddProduct();


        
        PersonPF personPF = new PersonPF();
        personPF.setName("João");
        personPF.setCpf("123456789");
        Client client = new Client();
        client.setPerson(personPF);
        
        InitApplication.init();
        
        System.out.println("\n\n");
        Set<Product> productSet = MemoryProductRepository.getInstance().findAll();
        System.out.println("Exibindo produtos que estão na memória: ");
        productSet.stream().forEach(System.out::println);


        viewCart.printCart(cart);
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

          
          
        System.out.println("\n\n");
        System.out.println(" Persistindo Purchase");
        System.out.println("\n\n");
        Purchase purchase = new Purchase();
        purchase.setOrderDate(LocalDate.now());
        purchase.setClient(client);
        purchase.setOrder(order);

        MemoryPurchaseRepository memoryPurchaseRepository = MemoryPurchaseRepository.getInstance();
        memoryPurchaseRepository.save(purchase);
        Set<Purchase> purchases = memoryPurchaseRepository.findAll();
        purchases.stream().forEach(System.out::println);
    }
}
