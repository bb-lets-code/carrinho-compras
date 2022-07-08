package br.shop.bb.repository.product;


import java.util.HashSet;
import java.util.Set;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.model.Client;
import br.shop.bb.model.Product;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.client.MemoryClientRepository;

public class ProductRepositoryFactory {
    public BaseRepository<Product, Integer> getBaseRepository(String type) {
        if (type.equals("MemoryClient")) {
            MemoryProductRepository memoryProductRepository = new MemoryProductRepository();
            Set<Product> productList = initializeDataSet();
            memoryProductRepository.saveAll(productList);
            return memoryProductRepository;
        }
        return null;
    }

    private Set<Product> initializeDataSet(){
        
        Set<Product> productList = new HashSet<Product>();
        Product product = new Product("Abacaxi", "Fruta", 10.0, TypeProduct.FOOD);
        Product product1 = new Product("Blusinha", "Fashion", 50.0, TypeProduct.CLOTHES);

        return productList;
    }
}
