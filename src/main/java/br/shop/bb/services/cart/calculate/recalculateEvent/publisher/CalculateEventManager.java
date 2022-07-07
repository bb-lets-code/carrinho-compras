package br.shop.bb.services.cart.calculate.recalculateEvent.publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.shop.bb.interfaces.EventListener;
import br.shop.bb.model.Cart;
import br.shop.bb.model.Product;

public class CalculateEventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public CalculateEventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, Cart cart, Product product) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.recalculate(eventType, cart, product);
        }
    }
    
}