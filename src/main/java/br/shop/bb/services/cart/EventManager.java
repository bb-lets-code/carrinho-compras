package br.shop.bb.services.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.shop.bb.interfaces.EventListener;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class EventManager {
    Map<String, EventListener> listeners = new HashMap<>();
    public EventManager() {
        
    }

    public void subscribe(String eventType, EventListener listener) {
        
        listeners.put(eventType, listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        
        listeners.remove(listener);
    }

    public void notify(String eventType, Cart cart, Product product) {
        for(EventListener listener : listeners.values()) {
            listener.update(cart,product);
        }
        

    }
}
