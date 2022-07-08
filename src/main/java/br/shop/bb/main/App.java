package br.shop.bb.main;

import java.util.List;
import java.util.Set;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Client;
import br.shop.bb.model.PersonPF;
import br.shop.bb.model.Product;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.client.ClientRepositoryFactory;
import br.shop.bb.repository.product.MemoryProductRepository;
import br.shop.bb.services.cart.AddProduct;
import br.shop.bb.services.cart.RemoveProduct;
import br.shop.bb.services.cart.ViewCart;

public class App {
    public static void main(String[] args) {
        Product product = new Product("Abacaxi", "Fruta", 10.0, TypeProduct.FOOD);
        Product product1 = new Product("Blusinha", "Fashion", 50.0, TypeProduct.CLOTHES);
        Cart cart = new Cart();
        AddProduct addProduct = new AddProduct();
        ViewCart viewCart = new ViewCart();

        // addProduct.addProducts(cart, product);
        addProduct.addProducts(cart, product);
        addProduct.addProducts(cart, product1);

        viewCart.printCart(cart);

        RemoveProduct removeProduct = new RemoveProduct();
        
        removeProduct.removeProductCart(cart, product1);
        viewCart.printCart(cart);

        ClientRepositoryFactory factoryBase = new ClientRepositoryFactory();
        BaseRepository<Client, Integer> memoryClientRepository = factoryBase.getBaseRepository("MemoryClient");
        PersonPF personPF = new PersonPF();
        personPF.setCpf("123456789");
        Client client = new Client();
        client.setPerson(personPF);
        
        System.out.println("\n\n");
        System.out.println("Persistindo cliente");
        System.out.println("\n\n");
        memoryClientRepository.save(client);
        memoryClientRepository.save(client);
        Set<Client> clients= memoryClientRepository.findAll();
        System.out.println(clients);
        System.out.println("\n\n");
        System.out.println("Removendo cliente");
        System.out.println("\n\n");
        memoryClientRepository.delete(client);
        clients= memoryClientRepository.findAll();
        System.out.println(clients);
        System.out.println("\n\n");
        System.out.println(" Persistindo product");
        System.out.println("\n\n");
        MemoryProductRepository memoryProductRepository = new MemoryProductRepository();
        memoryProductRepository.saveAll(memoryProductRepository.findAll());
        System.out.println("Cadastrando produto");
        System.out.println("\n\n");
        memoryProductRepository.save(product);
        Set<Product> products = memoryProductRepository.findAll();
        System.out.println(products);
        
        

    }
}
