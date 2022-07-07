package br.shop.bb.model;

import java.util.HashSet;

import br.shop.bb.annotations.ID;

public class Client extends BaseModel<Integer> {
    @ID
    private int idClient;
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

    public int getId() {
        return this.idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Client [cards=" + cards + ", idClient=" + idClient + ", person=" + person + "]";
    }
}
