package br.shop.bb.repository.client;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import br.shop.bb.main.Application;
import br.shop.bb.model.Client;
import br.shop.bb.repository.BaseRepository;

public class ClientRepositoryFactory {
    final Properties prop = new Properties();
    final String filePath = Application.class.getClassLoader().getResource("config.properties").getPath();

    public BaseRepository<Client, Integer> getBaseRepository() {
        getResources();
        if (this.prop.getProperty("origemDadosProducts").equals("EM_MEMORIA")) {
            return MemoryClientRepository.getInstance();
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

}
