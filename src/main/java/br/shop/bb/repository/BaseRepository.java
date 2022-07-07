package br.shop.bb.repository;

import br.shop.bb.model.BaseModel;
public interface BaseRepository<T extends BaseModel<ID>, ID> {


    default void save(T entity) {
        entity.setId(createID());
        persist(entity);
    }

    void persist(T entity);
    ID createID();
    void update(T entity);
    T getById(ID id);
    void findAll();
    void delete(T entity);

}