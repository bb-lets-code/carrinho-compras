package br.shop.bb.repository.product;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import br.shop.bb.enums.TypeProduct;
import br.shop.bb.main.App;
import br.shop.bb.model.Product;
import br.shop.bb.repository.BaseRepository;

public class ProductRepositoryFactory {
    final Properties prop = new Properties();
    final String filePath = App.class.getClassLoader().getResource("config.properties").getPath();

    public BaseRepository<Product, Integer> getBaseRepository() {
        getResources();
        if (this.prop.getProperty("origemDadosProducts").equals("EM_MEMORIA")) {
            MemoryProductRepository memoryProductRepository = MemoryProductRepository.getInstance();
            Set<Product> productList = initializeDataSet();
            memoryProductRepository.saveAll(productList);
            return memoryProductRepository;
        }

        
        return null;
    }

    
    private void getResources(){

        try (InputStream stream = new FileInputStream(filePath)) {
            prop.load(stream);
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo de configuração");
        }
    }

    private Set<Product> initializeDataSet(){
        
        Set<Product> productList = new HashSet<Product>();
        Product product = new Product("Abacaxi", "Fruta", 10.0, TypeProduct.FOOD);

        
        Product product1 = new Product("Blusinha 2", "Fashion", 45.0, TypeProduct.CLOTHES);
        Product product2 = new Product("Blusinha 3", "Fashion", 30.0, TypeProduct.CLOTHES);
        Product product3 = new Product("Blusinha 4", "Fashion", 20.0, TypeProduct.CLOTHES);

        //Incluindo acessórios

        Product product4 = new Product("Acessório 1", "Acessórios", 20.0, TypeProduct.ACCESSORIES);
        Product product5 = new Product("Acessório 2", "Acessórios", 15.0, TypeProduct.ACCESSORIES);
        Product product6 = new Product("Acessório 3", "Acessórios", 35.0, TypeProduct.ACCESSORIES);

        //Incluindo drinks

        Product product7 = new Product("Drink 1", "Drinks", 10.0, TypeProduct.DRINK);
        Product product8 = new Product("Drink 2", "Drinks", 15.0, TypeProduct.DRINK);
        Product product9 = new Product("Drink 3", "Drinks", 5.0, TypeProduct.DRINK);

        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);



        return productList;
    }
}
