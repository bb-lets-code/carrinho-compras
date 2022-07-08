package br.shop.bb.model;

import java.util.HashSet;

public abstract class Person {
    private String fullName;
    private HashSet<Address> address;

    public String getFullName() {
        return this.fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setAddress(Address address){
        this.address.add(address);
    }
   
    public abstract String getID();
    public abstract void setID(String id);
}
