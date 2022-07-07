package br.shop.bb.services.validators;

import br.shop.bb.model.PersonPJ;

public class VerifyClientIdentification implements Verify{
  
    public void verify(PersonPJ personPJ){
        if (personPJ.getCNPJ().length() != 11) {
            throw new RuntimeException("CNPJ inválido");
        }
    }
}
