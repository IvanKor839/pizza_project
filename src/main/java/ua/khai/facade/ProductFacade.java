package ua.khai.facade;

import ua.khai.dto.request.ProductRequestDto;
import ua.khai.dto.response.ProductResponseDto;

public interface ProductFacade extends CrudFacade<ProductResponseDto, ProductRequestDto>{
}
