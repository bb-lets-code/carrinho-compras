package br.shop.bb.services.singup;

import br.shop.bb.model.Client;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.ClientFactoryBase;
import br.shop.bb.repository.MemoryClientRepository;

public class SingUp {
    private BaseRepository<Client, Integer> memoryClientRepository = new MemoryClientRepository();
    
    ClientFactoryBase factoryBase = new ClientFactoryBase();
    public SingUp() {
        this.memoryClientRepository = factoryBase.getBaseRepository("MemoryClient");
    }
    public void createClient(Client client){
        //TODO: validações em cadeia de responsabilidade
            if(client != null){
                memoryClientRepository.persistir(client);
                
            }
    }

    public void listaTodos(){
        memoryClientRepository.listarTodos();
    }
}
