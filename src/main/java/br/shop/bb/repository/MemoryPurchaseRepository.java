package br.shop.bb.repository;

import java.util.ArrayList;
import java.util.List;

import br.shop.bb.model.Purchase;

public class MemoryPurchaseRepository implements BaseRepository<Purchase, Integer> {
    List<Purchase> purchaseList = new ArrayList<Purchase>();

    @Override
    public void persist(Purchase entity) {
        int id= entity.getId();
        if(id == 0) {
            id = purchaseList.size() + 1;
            entity.setId(id);
        }
        purchaseList.add(entity);
    }

    @Override
    public Integer createID() {
        return purchaseList.size();
    }

    @Override
    public void update(Purchase entity) {
        if(purchaseList.contains(entity)){
            purchaseList.set(purchaseList.indexOf(entity), entity);
        }        
    }

    @Override
    public Purchase getById(Integer id) {
        return purchaseList.get(id);
    }

    @Override
    public void findAll() {
        purchaseList.stream().forEach(System.out::println);
    }

    @Override
    public void delete(Purchase entity) {
        if(purchaseList.contains(entity)){
            purchaseList.remove(entity);
        }
    }


    
    
}
