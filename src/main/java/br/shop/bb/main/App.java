package br.shop.bb.main;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;
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

        System.out.println(" ------------- Update");

        updateQtProductCart.updateProductCart(cart, abacaxi, 5);
        viewCart.printCart(cart);
        

        
    }
}
