package br.shop.bb.main;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Client;
import br.shop.bb.model.Person;
import br.shop.bb.model.PersonPF;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.AddProduct;
import br.shop.bb.services.cart.RemoveProduct;
import br.shop.bb.services.singup.SingUp;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        Product product = new Product("Abacaxi", "Fruta", 10.0, TypeProduct.FOOD);
        Product product1 = new Product("Blusinha", "Fashion", 50.0, TypeProduct.CLOTHES);
        Cart cart = new Cart();
        AddProduct addProduct = new AddProduct();
        

        // addProduct.addProducts(cart, product);
        addProduct.addProducts(cart, product);
        addProduct.addProducts(cart, product1);

        
        System.out.println("------");

        for (Map.Entry<Product, Integer> value : cart.getProducts().entrySet()) {
            System.out.println(value.getKey().getName() + " - " + value.getValue());
        }

        System.out.println("----------");
        System.out.println("Total: " + cart.getTotal());
        
        System.out.println("----------");

        RemoveProduct removeProduct = new RemoveProduct();
        
        removeProduct.removeProductCart(cart, product1);

        
        for (Map.Entry<Product, Integer> value : cart.getProducts().entrySet()) {
            System.out.println(value.getKey().getName() + " - " + value.getValue());
        }
        System.out.println("----------");
        System.out.println("Total: " + cart.getTotal());

        PersonPF clientePF = new PersonPF();
        clientePF.setCpf("123456789");
        
        Client cliente = new Client();
        cliente.setPerson(clientePF);


        PersonPF clientePF2 = new PersonPF();
        clientePF2.setCpf("9874564123");
        
        Client cliente2 = new Client();
        cliente2.setPerson(clientePF2);

        SingUp singUp = new SingUp();
        singUp.createClient(cliente);
        singUp.createClient(cliente2);
        singUp.listaTodos();


    }
}
