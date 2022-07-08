package br.shop.bb.services.client.payment;

import br.shop.bb.model.Card;

public class AddCard {
    
    public void addCard(String number, String code, String flag) {
        Card card = new Card();
        card.setCode(code);
        card.setFlag(flag);
        card.setNumber(number);

        
        
    }
    
}
