package br.shop.bb.repository;

import java.util.List;
import java.util.Set;

import br.shop.bb.model.BaseModel;
import br.shop.bb.model.Client;
public interface BaseRepository<T extends BaseModel<ID>, ID> {


    default void save(T entity) {
        entity.setId(createID());
        persist(entity);
    }

    void persist(T entity);
    ID createID();
    void update(T entity);
    T getById(ID id);
    Set<T> findAll();
    void delete(T entity);

}