package br.shop.bb.services.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.shop.bb.main.Application;
import br.shop.bb.model.Client;
import br.shop.bb.model.Product;
import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;
import br.shop.bb.repository.client.ClientRepositoryFactory;

import br.shop.bb.repository.product.ProductRepositoryFactory;
import br.shop.bb.repository.purchase.PurchaseRepositoryFactory;

public class InitApplication {
    final Properties prop = new Properties();
    final String filePath = Application.class.getClassLoader().getResource("config.properties").getPath();

    
    private InitApplication() {
        System.out.println("Iniciando aplicação");
        getResources();
        InitDatabases();
        System.out.println("Aplicação iniciada");
    }

    public static void  init(){
        new InitApplication();
    }

    private void InitDatabases() {
        System.out.println("Iniciando banco de dados");
        final String dbType = prop.getProperty("origemDadosProducts");
        ClientRepositoryFactory factoryBase = new ClientRepositoryFactory();
        BaseRepository<Client, Integer> memoryClientRepository = factoryBase.getBaseRepository();
        ProductRepositoryFactory factoryBaseProduct = new ProductRepositoryFactory();
        BaseRepository<Product, Integer> memoryProductRepository = factoryBaseProduct.getBaseRepository();
        PurchaseRepositoryFactory factoryProductPurchase = new PurchaseRepositoryFactory();
        BaseRepository<Purchase, Integer> memoryPurchaseRepository = factoryProductPurchase.getBaseRepository();


        
    }

    private void getResources(){

        try (InputStream stream = new FileInputStream(filePath)) {
            prop.load(stream);
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo de configuração");
        }
    }
}
