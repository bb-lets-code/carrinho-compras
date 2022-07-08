package br.shop.bb.services.validators;

import br.shop.bb.model.Client;
import br.shop.bb.model.Person;
import br.shop.bb.model.PersonPF;
import br.shop.bb.model.PersonPJ;


public class VerifyClientIdentification implements Verify{
  
    public void verify(Client client){

        Person person = client.getPerson();

        if(person instanceof PersonPJ){
            if(person.getIdentification().length() != 14){
                throw new RuntimeException("CNPJ inválido");
            }
        }if(person instanceof PersonPF){
            if(person.getIdentification().length() != 11){
                throw new RuntimeException("CPF inválido");
            }
        }
    }
}
