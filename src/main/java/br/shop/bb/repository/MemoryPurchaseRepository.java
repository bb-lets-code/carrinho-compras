package br.shop.bb.repository;

import java.util.ArrayList;
import java.util.List;

import br.shop.bb.model.Purchase;

public class MemoryPurchaseRepository implements BaseRepository<Purchase, Integer> {
    List<Purchase> purchaseList = new ArrayList<Purchase>();

    

    @Override
    public void persistir(Purchase entity) {
        purchaseList.add(entity);
    }

    @Override
    public Integer criarId() {
        return purchaseList.size();
    }

    @Override
    public void atualizar(Purchase entity) {
        if(purchaseList.contains(entity)){
            purchaseList.set(purchaseList.indexOf(entity), entity);
        }        
    }

    @Override
    public Purchase getById(Integer id) {
        return purchaseList.get(id);
    }

    @Override
    public void listarTodos() {
        purchaseList.stream().forEach(System.out::println);
    }

    @Override
    public void excluir(Purchase entity) {
        if(purchaseList.contains(entity)){
            purchaseList.remove(entity);
        }
        
    }


    
    
}
