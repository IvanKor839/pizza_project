package ua.khai.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.khai.crud.CrudRepositoryHelper;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.entity.Product;
import ua.khai.entity.user.Personal;
import ua.khai.exception.EntityNotFoundException;
import ua.khai.repository.PersonalRepository;
import ua.khai.service.PersonalCrudService;
import ua.khai.service.ProductService;

import java.util.Optional;

@Service
public class PersonalCrudServiceImpl implements PersonalCrudService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final PersonalRepository personalRepository;
    private final CrudRepositoryHelper <Personal, PersonalRepository> crudRepositoryHelper;

    public PersonalCrudServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, PersonalRepository productRepository, CrudRepositoryHelper<Personal, PersonalRepository> crudRepositoryHelper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.personalRepository = productRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void create(Personal entity) {
        System.out.println(personalRepository.existsByEmail(entity.getEmail()));
        if(personalRepository.existsByEmail(entity.getEmail())){
            throw new EntityNotFoundException("This person is exist");
        }
        System.out.println(entity.getPassword());
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        crudRepositoryHelper.create(personalRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void update(Personal entity) {
        crudRepositoryHelper.update(personalRepository, entity);
    }



    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(personalRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Personal> findById(Long id) {
        return crudRepositoryHelper.findById(personalRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<Personal> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(personalRepository, request);
    }
}
