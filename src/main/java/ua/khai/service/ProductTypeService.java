package ua.khai.service;

import ua.khai.entity.ProductType;

import java.util.List;

public interface ProductTypeService extends BaseCrudService<ProductType> {

    List<ProductType> findAll();
}
