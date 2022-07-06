package br.shop.bb.interfaces;

import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public interface EventListener {
     void update( Cart cart, Product product) ;

}
