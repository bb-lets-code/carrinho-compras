package br.shop.bb.repository.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.shop.bb.model.Client;
import br.shop.bb.repository.BaseRepository;

public class MemoryClientRepository implements BaseRepository<Client, Integer>  {


    Set<Client> clientList = new HashSet<Client>();
    @Override
    public void persist(Client entity) {
        int id = entity.getId();
        if(id == 0) {
            id = clientList.size() + 1;
            entity.setId(id);
        }
        clientList.add(entity);
        
    }

    @Override
    public Integer createID() {
        return clientList.size();
        
    }
    @Override

    public void update(Client entity) {
        if(clientList.contains(entity)){
            clientList.stream().filter(c -> c.getId() == entity.getId()).forEach(c -> c = entity);
        }        
    }

    @Override
    public Client getById(Integer id) {
        return clientList.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    @Override
    public Set<Client> findAll() {
        return clientList;
    }

    @Override
    public void delete(Client entity) {
        if(clientList.contains(entity)){
            clientList.remove(entity);
        }
    }


    
}
