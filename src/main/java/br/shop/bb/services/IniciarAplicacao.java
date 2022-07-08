package br.shop.bb.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.management.RuntimeErrorException;

import br.shop.bb.model.Product;

public class IniciarAplicacao {

    final Properties prop = new Properties();
    final String filePath = IniciarAplicacao.class.getClassLoader().getResource("config.properties").getPath();

    
    public void iniciarAplicacao(String... args){
        recuperarListaProdutos();
    }

    private Set<Product> recuperarListaProdutos() {
        String origemDaDos =getOrigemDados();
        
    }

    private String getOrigemDados(final String... args) {
        String origemDados ;
        if (args.length != 0 && !args[0].isBlank()) {
            origemDados = args[0];
          } else {
              
              try (InputStream stream = new FileInputStream(filePath)) {
                  this.prop.load(stream);
              } catch (Exception e) {
                  System.out.println("Erro ao carregar arquivo de configuração");
              }
          
              origemDados = prop.getProperty("origemDadosProducts");
          }
          
          if (origemDados.isBlank()) {
            System.out.println("Origem de dados não definida");

          }
          
          return origemDados;
    }


}
