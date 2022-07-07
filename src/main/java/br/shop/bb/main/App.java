package br.shop.bb.main;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Client;
import br.shop.bb.model.Product;
import br.shop.bb.services.cart.AddProduct;
import br.shop.bb.services.cart.ListProductsCart;
import br.shop.bb.services.cart.RemoveProduct;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        Product product = new Product("Abacaxi", "Fruta", 10.0, TypeProduct.FOOD);
        Product product1 = new Product("Blusinha", "Fashion", 50.0, TypeProduct.CLOTHES);
        Client client = new Client();

        Cart cart = new Cart();
        AddProduct addProduct = new AddProduct();
        ListProductsCart listProductsCart = new ListProductsCart();

        addProduct.addProducts(cart, product);
        addProduct.addProducts(cart, product);
        addProduct.addProducts(cart, product1);

        System.out.println(cart.getTotal());

        listProductsCart.listProductsCart(cart);

        RemoveProduct removeProduct = new RemoveProduct();
        removeProduct.removeProductCart(cart, product1);

        System.out.println(cart.getTotal());

        listProductsCart.listProductsCart(cart);
    }
}
