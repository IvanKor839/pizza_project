package ua.khai.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.khai.crud.CrudRepositoryHelper;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.entity.ProductType;
import ua.khai.repository.ProductTypeRepository;
import ua.khai.service.ProductTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class ProducTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;
    private final CrudRepositoryHelper <ProductType, ProductTypeRepository> crudRepositoryHelper;

    public ProducTypeServiceImpl(ProductTypeRepository productTypeRepository, CrudRepositoryHelper<ProductType, ProductTypeRepository> crudRepositoryHelper) {
        this.productTypeRepository = productTypeRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(ProductType entity) {
        crudRepositoryHelper.create(productTypeRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(ProductType entity) {
        crudRepositoryHelper.update(productTypeRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(productTypeRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductType> findById(Long id) {
        return crudRepositoryHelper.findById(productTypeRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<ProductType> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(productTypeRepository, request);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
