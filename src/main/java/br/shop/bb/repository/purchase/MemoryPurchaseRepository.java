package br.shop.bb.repository.purchase;

import java.util.HashSet;
import java.util.Set;

import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;

public class MemoryPurchaseRepository implements BaseRepository<Purchase, Integer> {
    
    private static MemoryPurchaseRepository instance;

    private MemoryPurchaseRepository() {
        

    }

    public static MemoryPurchaseRepository getInstance() {
        if (instance == null) {
            instance = new MemoryPurchaseRepository();
        }
        return instance;
    }
    Set<Purchase> purchaseList = new HashSet<Purchase>();

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
            purchaseList.remove(entity);
            purchaseList.add(entity);
        }        
    }

    @Override
    public Purchase getById(Integer id) {
        for(Purchase purchase : purchaseList) {
            if(purchase.getId() == id) {
                return purchase;
            }
        }
        return null;
    }

    @Override
    public Set<Purchase> findAll() {
        return purchaseList;
    }

    @Override
    public void delete(Purchase entity) {
        if(purchaseList.contains(entity)){
            purchaseList.remove(entity);
        }
    }


    
    
}
