package br.shop.bb.main;

import java.util.Set;

import br.shop.bb.enums.Installments;
import br.shop.bb.enums.PaymentType;
import br.shop.bb.model.Card;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Client;
import br.shop.bb.model.CreditCard;
import br.shop.bb.model.Order;
import br.shop.bb.model.Payment;
import br.shop.bb.model.PaymentMethod;
import br.shop.bb.model.PersonPF;
import br.shop.bb.model.Product;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.client.MemoryClientRepository;
import br.shop.bb.repository.product.MemoryProductRepository;
import br.shop.bb.repository.product.ProductRepositoryFactory;
import br.shop.bb.services.application.InitApplication;
import br.shop.bb.services.cart.AddProduct;
import br.shop.bb.services.cart.RemoveProduct;
import br.shop.bb.services.cart.ViewCart;
import br.shop.bb.services.client.singup.SingUp;
import br.shop.bb.services.order.OrderBuilder;
import br.shop.bb.services.order.OrderTemplate;
import br.shop.bb.services.order.PayOrder;


public class Application {
    public static void main(String[] args) {
        
        System.out.println("\n\n");
        System.out.println("Inicializando aplicação");
        System.out.println("\n\n");
        

        InitApplication.init();

        System.out.println("\n\n");

        System.out.println("Cliente entra no Ecommerce: ");
        System.out.println("Um carrinho é vinculado ao cliente");
        Cart cart = new Cart();

        System.out.println("\n\n");

        System.out.println("Exibindo produtos que estão no database: ");
        MemoryProductRepository.getInstance().findAll().stream().forEach(System.out::println);

        System.out.println("\n\n");
        System.out.println("Cadastrando cliente: ");
        PersonPF personPF = new PersonPF();
        personPF.setName("João");
        personPF.setCpf("12345678910");

        Client client = new Client();
        client.setPerson(personPF);
        SingUp singUp = new SingUp();
        singUp.singUp(client);

        System.out.println("\n\n");
        System.out.println("Exibindo clientes que estão no database: ");
        MemoryClientRepository.getInstance().findAll().stream().forEach(System.out::println);
        Set<Product> products = MemoryProductRepository.getInstance().findAll();

        System.out.println("\n\n");
        System.out.println("Exibindo carrinho vazio: ");

        ViewCart viewCart = new ViewCart();
        viewCart.printCart(cart);

        System.out.println("\n\n");
        System.out.println("Cliente escolhe um produto e inclui no Cart");
        System.out.println("\n\n");

        AddProduct addProduct = new AddProduct();
        addProduct.addProducts(cart, products.stream().findFirst().get());
        addProduct.addProducts(cart, products.stream().findFirst().get());
        ProductRepositoryFactory factoryBaseProduct = new ProductRepositoryFactory();
        BaseRepository<Product, Integer> baseRepository = factoryBaseProduct.getBaseRepository();
        Product productAny = baseRepository.getById(3);
        addProduct.addProducts(cart, productAny);



        System.out.println("Carrinho do cliente atualizado: ");
        viewCart.printCart(cart);

        System.out.println("\n\n");
        System.out.println("Incluindo novo produto no Cart");
        Product product = products.stream().findAny().get();
        addProduct.addProducts(cart, product);
        System.out.println("\n\n");


        System.out.println("Carrinho do cliente atualizado: ");
        viewCart.printCart(cart);

        System.out.println("\n\n");
        System.out.println("Cliente escolhe um novo produto e remove do Cart");
        RemoveProduct removeProduct = new RemoveProduct();
        removeProduct.removeProductCart(cart, product);

        System.out.println("\n\n");

        System.out.println("Carrinho do cliente atualizado: ");
        viewCart.printCart(cart);


        
        // Create Order in Close cart

        Card card = new Card();
        card.setNumber("4526412365478965");
        card.setFlag("Visa");
        card.setCode("452");

        PaymentMethod method = new PaymentMethod();
        method.setPaymentType(PaymentType.CREDITCARD);
        Payment payment = new CreditCard(card, Installments.TEN);
        // System.out.println(payment.getPaid());
        OrderTemplate orderTem = new OrderTemplate();
        OrderBuilder builder = new OrderBuilder();

        orderTem.constructOrder(cart, method, payment, builder);

        Order order = builder.getOrderResult();

        PayOrder pay = new PayOrder();

        pay.payOrder(order);
        System.out.println("\n\n");

        System.out.println("Data do pagamento: ");
        System.out.println(order.getPayment().getPaid());
        System.out.println("Total pago: ");
        System.out.println(order.getPayment().getTotal());



        
    }
}
