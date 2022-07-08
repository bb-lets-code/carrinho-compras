package br.shop.bb.services.purchase;

import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.purchase.MemoryPurchaseRepository;

public class UpdatePurchase {
    
    private BaseRepository<Purchase, Integer> purchaseRepository;
    
    public UpdatePurchase(){
        this.purchaseRepository = new MemoryPurchaseRepository();
    }
    public void updatePurchase(Purchase purchase) {
        if(purchase.getId() != null) {
            purchaseRepository.update(purchase);
        }
    }
    
}
