package br.shop.bb.repository;


import br.shop.bb.model.Client;

public class ClientFactoryBase {
    public BaseRepository<Client, Integer> getBaseRepository(String type) {
        if (type.equals("MemoryClient")) {
            return new MemoryClientRepository();
        }
        return null;
    }
}
