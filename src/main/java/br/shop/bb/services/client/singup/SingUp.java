package br.shop.bb.services.client.singup;

import br.shop.bb.model.Client;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.client.ClientRepositoryFactory;
import br.shop.bb.repository.client.MemoryClientRepository;

public class SingUp {
    private BaseRepository<Client, Integer> memoryClientRepository = MemoryClientRepository.getInstance();
    
    ClientRepositoryFactory factoryBase = new ClientRepositoryFactory();
    public SingUp() {
        this.memoryClientRepository = factoryBase.getBaseRepository("MemoryClient");
    }
    public void createClient(Client client){
        //TODO: validações em cadeia de responsabilidade
            if(client != null){
                memoryClientRepository.persist(client);
                
            }
    }

    public void listaTodos(){
        memoryClientRepository.findAll();
    }
}
