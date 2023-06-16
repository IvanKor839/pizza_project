package ua.khai.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.khai.crud.CrudRepositoryHelper;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.entity.Product;
import ua.khai.repository.ProductRepository;
import ua.khai.service.ProductService;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CrudRepositoryHelper <Product, ProductRepository> crudRepositoryHelper;

    public ProductServiceImpl(ProductRepository productRepository, CrudRepositoryHelper<Product, ProductRepository> crudRepositoryHelper) {
        this.productRepository = productRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(Product entity) {
        crudRepositoryHelper.create(productRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(Product entity) {
        crudRepositoryHelper.update(productRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(productRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return crudRepositoryHelper.findById(productRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<Product> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(productRepository, request);
    }
}
