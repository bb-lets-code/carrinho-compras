package br.shop.bb.repository;



import java.util.List;

import br.shop.bb.model.BaseModel;
public interface BaseRepository<T extends BaseModel<ID>, ID> {

    default void salvar(T entity) {
        entity.setId(criarId());
        persistir(entity);
    }

    void persistir(T entity);
    ID criarId();
    void atualizar(T entity);
    T getById(ID id);
    List<T> listarTodos();
    void excluir(T entity);

}