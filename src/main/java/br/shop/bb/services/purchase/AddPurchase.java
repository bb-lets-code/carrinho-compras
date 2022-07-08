package br.shop.bb.services.purchase;

import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.purchase.MemoryPurchaseRepository;

public class AddPurchase {
    private BaseRepository<Purchase, Integer> purchaseRepository;
    
    public AddPurchase(){
        this.purchaseRepository = new MemoryPurchaseRepository();
    }
    public void addPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

}
