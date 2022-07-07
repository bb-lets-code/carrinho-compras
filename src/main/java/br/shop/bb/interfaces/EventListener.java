package br.shop.bb.interfaces;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public interface EventListener {
     void update(String eventType, Cart cart, Product product) ;

}
