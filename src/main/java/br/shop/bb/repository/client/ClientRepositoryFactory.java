package br.shop.bb.repository.client;


import br.shop.bb.model.Client;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.product.MemoryProductRepository;

public class ClientRepositoryFactory {

    public BaseRepository<Client, Integer> getBaseRepository(String type) {
        if (type.equals("EM_MEMORIA")) {
            return MemoryClientRepository.getInstance();
        }
        return null;
    }

}
