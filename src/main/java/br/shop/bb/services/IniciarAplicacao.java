package br.shop.bb.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import br.shop.bb.model.Product;

public class IniciarAplicacao {
    
    public void iniciarAplicacao(String... args){
        recuperarListaProdutos();
    }

    private List<Product> recuperarListaProdutos(String... args) {
        String origemDaDos =getOrigemDados(args);
        
    }

    private String getOrigemDados(final String... args) {
        String origemDados ;
        if (args.length != 0 && !args[0].isBlank()) {
            origemDados = args[0];
          } else {
              final Properties prop = new Properties();
              final String filePath = IniciarAplicacao.class.getClassLoader().getResource("config.properties").getPath();
              try (InputStream stream = new FileInputStream(filePath)) {
                  prop.load(stream);
                
              } catch (Exception e) {
                  throw new Exception(e);
              }
          
              origemDados = prop.getProperty("origemDadosProducts");
          }
          
          if (origemDados.isBlank()) {
            throw new Exception("Origem de dados não informada");

          }
          
          return origemDados;
    }


}
