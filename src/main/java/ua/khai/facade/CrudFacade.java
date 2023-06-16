package ua.khai.facade;

import org.springframework.web.context.request.WebRequest;
import ua.khai.dto.request.RequestDto;
import ua.khai.dto.response.PageData;
import ua.khai.dto.response.ResponseDto;

import java.io.IOException;
import java.sql.SQLException;

public interface CrudFacade<RES extends ResponseDto, REQ extends RequestDto>{

    void create(REQ entity);
    void delete(Long id);
    void update(REQ entity, Long id) throws SQLException;
    RES findById(Long id);
    PageData<RES> findAll(WebRequest request) throws IOException;
}