package br.shop.bb.services.purchase;

import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.purchase.MemoryPurchaseRepository;

public class RemovePurchase {
    private BaseRepository<Purchase, Integer> purchaseRepository;
    
    public RemovePurchase(){
        this.purchaseRepository = new MemoryPurchaseRepository();
    }
    public void removePurchase(Purchase purchase) {
        if(purchase.getId() != null) {
            purchaseRepository.delete(purchase);
        }
    }
    
}
