package br.shop.bb.clientService;

import java.util.List;


import br.shop.bb.model.Client;

import br.shop.bb.services.validators.Verify;
import br.shop.bb.services.validators.VerifyClientIdentification;

public class VerifyClient {

    public static boolean verifyClient(Client client) {

        try {
            List<Verify> validations = List.of(
                    new VerifyClientIdentification());

            for (Verify validation : validations) {
                validation.verify(client);
            }
        } catch (Exception e) {
            System.out.println("Erro! Verifique os dados identificados");
            return false;
        }
        return true;
    }
}
