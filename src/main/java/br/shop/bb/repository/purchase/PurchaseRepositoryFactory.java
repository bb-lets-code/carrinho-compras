package br.shop.bb.repository.purchase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.shop.bb.enums.TypeDatabase;
import br.shop.bb.main.Application;
import br.shop.bb.model.Purchase;
import br.shop.bb.repository.BaseRepository;

public class PurchaseRepositoryFactory {
    final Properties prop = new Properties();
    final String filePath = Application.class.getClassLoader().getResource("config.properties").getPath();

    public BaseRepository<Purchase, Integer> getBaseRepository() {
        getResources();

        if (this.prop.getProperty("origemDadosProducts").equals(TypeDatabase.EM_MEMORY.getDatabaseType())) {
            return MemoryPurchaseRepository.getInstance();
        } else {
            return null;
        }
    }

    private void getResources() {
        
        try (InputStream stream = new FileInputStream(filePath)) {
            prop.load(stream);
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo de configuração");
        }
    }
}
