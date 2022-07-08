package br.shop.bb.repository.purchase;

import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;

public class PurchaseRepositoryFactory {
    public BaseRepository<Purchase, Integer> getBaseRepository(String dbType) {
        if (dbType.equals("EM_MEMORIA")) {
            return MemoryPurchaseRepository.getInstance();
        } else {
            return null;
        }
    }
}
