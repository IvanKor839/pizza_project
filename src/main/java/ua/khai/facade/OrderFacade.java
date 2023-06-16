package ua.khai.facade;

import ua.khai.dto.request.OrderRequestDto;
import ua.khai.dto.request.ProductRequestDto;
import ua.khai.dto.response.OrderResponseDto;
import ua.khai.dto.response.ProductResponseDto;

public interface OrderFacade extends CrudFacade<OrderResponseDto, OrderRequestDto>{
}
