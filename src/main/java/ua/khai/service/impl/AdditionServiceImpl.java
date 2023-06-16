package ua.khai.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.khai.crud.CrudRepositoryHelper;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.entity.Addition;
import ua.khai.entity.Product;
import ua.khai.repository.AdditionRepository;
import ua.khai.repository.ProductRepository;
import ua.khai.service.AdditionService;
import ua.khai.service.ProductService;

import java.util.Optional;

@Service
public class AdditionServiceImpl implements AdditionService {

    private final AdditionRepository additionRepository;
    private final CrudRepositoryHelper <Addition, AdditionRepository> crudRepositoryHelper;

    public AdditionServiceImpl(AdditionRepository additionRepository, CrudRepositoryHelper<Addition, AdditionRepository> crudRepositoryHelper) {
        this.additionRepository = additionRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(Addition entity) {
        crudRepositoryHelper.create(additionRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(Addition entity) {
        crudRepositoryHelper.update(additionRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(additionRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Addition> findById(Long id) {
        return crudRepositoryHelper.findById(additionRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<Addition> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(additionRepository, request);
    }
}
