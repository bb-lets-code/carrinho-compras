package br.shop.bb.services.client.singup;

import br.shop.bb.clientService.VerifyClient;
import br.shop.bb.model.Client;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.client.ClientRepositoryFactory;
import br.shop.bb.repository.client.MemoryClientRepository;

public class SingUp {
    private BaseRepository<Client, Integer> memoryClientRepository = MemoryClientRepository.getInstance();
    
    ClientRepositoryFactory factoryBase = new ClientRepositoryFactory();
    public SingUp() {
        this.memoryClientRepository = factoryBase.getBaseRepository();
    }
    public void singUp(Client client){
        VerifyClient verifyClient = new VerifyClient();
        verifyClient.verifyClient(client);

            if(client != null){
                memoryClientRepository.persist(client);
                
            }
    }

    public void listaTodos(){
        memoryClientRepository.findAll();
    }
}
