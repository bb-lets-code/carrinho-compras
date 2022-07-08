package br.shop.bb.main;

import java.time.LocalDate;
import java.util.Set;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Client;
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

public class App {
    public static void main(String[] args) {
        Product abacaxi = new Product("Abacaxi", "Fruta", 10.0, TypeProduct.FOOD);
        Product blusinha = new Product("Blusinha", "Fashion", 50.0, TypeProduct.CLOTHES);
        Cart cart = new Cart();
        AddProduct addProduct = new AddProduct();
        ViewCart viewCart = new ViewCart();

        // addProduct.addProducts(cart, product);
        System.out.println("Add");
        addProduct.addProducts(cart, abacaxi);
        addProduct.addProducts(cart, blusinha);

            
        viewCart.printCart(cart);

        RemoveProduct removeProduct = new RemoveProduct();
        System.out.println("Remove");
        
        removeProduct.removeProductCart(cart, blusinha);
        UpdateQtProductCart updateQtProductCart = new UpdateQtProductCart();
        viewCart.printCart(cart);

        PersonPF personPF = new PersonPF();
        personPF.setCpf("123456789");
        Client client = new Client();
        client.setPerson(personPF);
        
        // System.out.println("\n\n");
        // System.out.println("Persistindo cliente");
        // System.out.println("\n\n");
        // memoryClientRepository.save(client);
        // memoryClientRepository.save(client);
        // Set<Client> clients= memoryClientRepository.findAll();
        // System.out.println(clients);
        
        // System.out.println("\n\n");
        // System.out.println("Persistindo produto");
        // System.out.println("\n\n");
        

        // ProductRepositoryFactory factoryBaseProduct = new ProductRepositoryFactory();
        // BaseRepository<Product, Integer> memoryClientRepository1 = factoryBaseProduct.getBaseRepository("MemoryClient");
        // product.setName("Abacaxi 2");
        // memoryClientRepository1.save(product);
        // Set<Product> productSet = memoryClientRepository1.findAll();
        // productSet.stream().forEach(System.out::println);
        
        InitApplication.init();
        
        MemoryProductRepository memoryProductRepository = MemoryProductRepository.getInstance();
        Set<Product> productSet = memoryProductRepository.findAll();
        productSet.stream().forEach(System.out::println);



        System.out.println("\n\n");
        System.out.println(" Persistindo Purchase");
        System.out.println("\n\n");
        Purchase purchase = new Purchase();
        purchase.setOrderDate(LocalDate.now());

        MemoryPurchaseRepository memoryPurchaseRepository = MemoryPurchaseRepository.getInstance();
        memoryPurchaseRepository.save(purchase);
        Set<Purchase> purchases = memoryPurchaseRepository.findAll();
        purchases.stream().forEach(System.out::println);
    }
}
