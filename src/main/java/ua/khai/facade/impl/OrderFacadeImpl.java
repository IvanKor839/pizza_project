package ua.khai.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.khai.datatable.DataTableRequest;
import ua.khai.datatable.DataTableResponse;
import ua.khai.dto.request.OrderRequestDto;
import ua.khai.dto.response.OrderResponseDto;
import ua.khai.dto.response.PageData;
import ua.khai.entity.Order;
import ua.khai.facade.OrderFacade;
import ua.khai.service.OrderService;
import ua.khai.util.WebUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderFacadeImpl implements OrderFacade {

    private final OrderService orderService;

    public OrderFacadeImpl(OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public void create(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setAdmin(orderRequestDto.getAdmin());
        order.setActive("В процесі");
        order.setAdress(orderRequestDto.getAdress());
        order.setPersonal(orderRequestDto.getPersonal());
        order.setPaied(true);
        order.setCard(orderRequestDto.getCard());
        orderService.create(order);
    }

    @Override
    public void delete(Long id) {
        orderService.delete(id);
    }

    @Override
    public void update(OrderRequestDto orderRequestDto, Long id) throws SQLException {
        Optional<Order> optionalOrder = orderService.findById(id);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setActive(orderRequestDto.getActive());
            order.setAdress(orderRequestDto.getAdress());
            order.setPaied(orderRequestDto.getPaied());
            orderService.update(order);
        }
    }

    @Override
    public OrderResponseDto findById(Long id) {
        Order order = orderService.findById(id).get();
        return new OrderResponseDto(order);
    }

    @Override
    public PageData<OrderResponseDto> findAll(WebRequest request) throws IOException {
        DataTableRequest dataTableRequest = WebUtil.generateDataTableRequestByWebRequest(request);
        DataTableResponse<Order> tableResponse = orderService.findAll(dataTableRequest);
        List<OrderResponseDto> orders = tableResponse.getItems().stream().
                map(OrderResponseDto::new).
                collect(Collectors.toList());

        PageData<OrderResponseDto> pageData = (PageData<OrderResponseDto>) WebUtil.initPageData(tableResponse);
        pageData.setItems(orders);
        return pageData;
    }
}
