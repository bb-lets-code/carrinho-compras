package br.shop.bb.repository.purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;

public class MemoryPurchaseRepository implements BaseRepository<Purchase, Integer> {
    List<Purchase> purchaseList = new ArrayList<Purchase>();
    private static MemoryPurchaseRepository instance;

    private MemoryPurchaseRepository() {
        

    }

    public static MemoryPurchaseRepository getInstance() {
        if (instance == null) {
            instance = new MemoryPurchaseRepository();
        }
        return instance;
    }

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
    public Set<Purchase> findAll() {
       return null;
    }

    @Override
    public void delete(Purchase entity) {
        if(purchaseList.contains(entity)){
            purchaseList.remove(entity);
        }
    }


    
    
}
