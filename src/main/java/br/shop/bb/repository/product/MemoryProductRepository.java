package br.shop.bb.repository.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.shop.bb.model.Product;
import br.shop.bb.repository.BaseRepository;

public class MemoryProductRepository implements BaseRepository<Product, Integer>{

    Set<Product> productList = new HashSet<Product>();



    private MemoryProductRepository(){

    }

    public static MemoryProductRepository getInstance(){
        return new MemoryProductRepository();
    }

    @Override
    public void persist(Product entity) {
       
        Integer id = entity.getId();
        if(id == 0) {
            id = productList.size() + 1;
            entity.setId(id);
        }
        productList.add(entity);

        
    }

    @Override
    public Integer createID() {
        return productList.size();
    }

    @Override
    public void update(Product entity) {
        if(productList.contains(entity)){
            productList.stream().filter(p -> p.getId() == entity.getId()).forEach(p -> p = entity);
        }
        
    }

    @Override
    public Product getById(Integer id) {
        return productList.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    @Override
    public Set<Product> findAll() {
        return productList;
    }

    @Override
    public void delete(Product entity) {
        if(productList.contains(entity)){
            productList.remove(entity);
        }
    }

    public void saveAll(Set<Product> productList2) {
        productList2.forEach(p -> persist(p));
    }

}
