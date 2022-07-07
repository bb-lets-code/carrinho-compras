package br.shop.bb.model;

import java.util.HashSet;

import br.shop.bb.annotations.ID;

public class Client extends BaseModel<Integer> {
    @ID
    private int idClient;
    private Person person;
    private HashSet<Card> cards;

    public HashSet<Card> getCards() {
        return cards;
    }

    public void setCards(Card cards) {
        this.cards.add(cards);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
