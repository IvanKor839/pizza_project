package ua.khai.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.dto.request.ProductRequestDto;
import ua.khai.dto.response.PageData;
import ua.khai.dto.response.ProductResponseDto;
import ua.khai.entity.Product;
import ua.khai.facade.ProductFacade;
import ua.khai.service.ProductService;
import ua.khai.util.WebUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;

    public ProductFacadeImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void create(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getProductName());
        product.setProductType(productRequestDto.getProductType());
        product.setPrice(productRequestDto.getPrice());
        product.setPicture(productRequestDto.getPicture());
        product.setSize(productRequestDto.getSize());
        product.setWeight(productRequestDto.getWeight());
        productService.create(product);
    }

    @Override
    public void delete(Long id) {
        productService.delete(id);
    }

    @Override
    public void update(ProductRequestDto productRequestDto, Long id) throws SQLException {
        Optional<Product> optionalProduct = productService.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(productRequestDto.getProductName());
            product.setProductType(productRequestDto.getProductType());
            product.setPrice(productRequestDto.getPrice());
            product.setPicture(productRequestDto.getPicture());
            product.setSize(productRequestDto.getSize());
            product.setWeight(productRequestDto.getWeight());
            productService.update(product);
        }
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Product product = productService.findById(id).get();
        return new ProductResponseDto(product);
    }

    @Override
    public PageData<ProductResponseDto> findAll(WebRequest request) throws IOException {
        DataTableRequest dataTableRequest = WebUtil.generateDataTableRequestByWebRequest(request);
        DataTableResponse<Product> tableResponse = productService.findAll(dataTableRequest);
        List<ProductResponseDto> products = tableResponse.getItems().stream().
                map(ProductResponseDto::new).
                collect(Collectors.toList());

        PageData<ProductResponseDto> pageData = (PageData<ProductResponseDto>) WebUtil.initPageData(tableResponse);
        pageData.setItems(products);
        return pageData;
    }
}
