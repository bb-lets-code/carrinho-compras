package br.shop.bb.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import br.shop.bb.model.Client;
import br.shop.bb.model.Product;
import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.client.ClientRepositoryFactory;

import br.shop.bb.repository.product.ProductRepositoryFactory;
import br.shop.bb.repository.purchase.PurchaseRepositoryFactory;

public class InitApplication {
    

    
    private InitApplication() {
        System.out.println("Iniciando aplicação");
        
        InitDatabases();
        System.out.println("Aplicação iniciada");
    }

    public static void  init(){
        new InitApplication();
    }

    private void InitDatabases() {
        System.out.println("Iniciando banco de dados");
        ClientRepositoryFactory clientFactoryBase = new ClientRepositoryFactory();
        BaseRepository<Client, Integer> memoryClientRepository = clientFactoryBase.getBaseRepository();
        ProductRepositoryFactory factoryBaseProduct = new ProductRepositoryFactory();
        BaseRepository<Product, Integer> memoryProductRepository = factoryBaseProduct.getBaseRepository();
        PurchaseRepositoryFactory factoryProductPurchase = new PurchaseRepositoryFactory();
        BaseRepository<Purchase, Integer> memoryPurchaseRepository = factoryProductPurchase.getBaseRepository();

        
    }

}