package ua.khai.service;

import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.entity.BaseEntity;

import java.util.Optional;

public interface BaseCrudService<E extends BaseEntity>{

    void create(E entity);
    void update(E entity);
    void delete(Long id);
    Optional<E> findById(Long id);
    DataTableResponse<E> findAll(DataTableRequest request);

}
