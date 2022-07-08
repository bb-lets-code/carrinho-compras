package br.shop.bb.model;

import java.util.HashSet;

public abstract class Person {
   
    private String name;
    private HashSet<Address> address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(Address address){
        this.address.add(address);
    }

    public abstract String getIdentification();
    public abstract void setIdentification(String id);
}
