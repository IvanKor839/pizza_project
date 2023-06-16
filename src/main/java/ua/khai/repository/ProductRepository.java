package ua.khai.repository;

import org.springframework.stereotype.Repository;
import ua.khai.entity.Product;
import ua.khai.entity.ProductType;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product>{

    List<Product> findByProductType(ProductType productType);
}
