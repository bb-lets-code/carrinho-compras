package br.shop.bb.model;

import java.util.HashSet;

public class Client {
    private Person person;
    private HashSet<Cards> cards;

    public HashSet<Cards> getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards.add(cards);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
