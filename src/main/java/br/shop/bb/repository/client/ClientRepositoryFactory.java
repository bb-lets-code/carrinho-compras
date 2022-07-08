package br.shop.bb.repository.client;


import br.shop.bb.model.Client;
import br.shop.bb.repository.BaseRepository;

public class ClientRepositoryFactory {
    public BaseRepository<Client, Integer> getBaseRepository(String type) {
        if (type.equals("MemoryClient")) {
            return MemoryClientRepository.getInstance();
        }
        return null;
    }
}
