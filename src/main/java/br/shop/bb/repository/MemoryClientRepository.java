package br.shop.bb.repository;

import java.util.ArrayList;
import java.util.List;

import br.shop.bb.model.Client;

public class MemoryClientRepository implements BaseRepository<Client, Integer>  {


    List<Client> clientList = new ArrayList<Client>();
    @Override
    public void persistir(Client entity) {
        int id = entity.getId();
        if(id == 0) {
            id = clientList.size() + 1;
            entity.setId(id);
        }
        clientList.add(entity);
        
    }

    @Override
    public Integer criarId() {
        return clientList.size();
        
    }
    @Override

    public void atualizar(Client entity) {
        if(clientList.contains(entity)){
            clientList.set(clientList.indexOf(entity), entity);
        }        
    }

    @Override
    public Client getById(Integer id) {
        return clientList.get(id);
    }

    @Override
    public void listarTodos() {
        clientList.stream().forEach(System.out::println);
    }

    @Override
    public void excluir(Client entity) {
        if(clientList.contains(entity)){
            clientList.remove(entity);
        }
    }

    
}
