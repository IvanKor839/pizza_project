package ua.khai.facade;


import ua.khai.dto.request.register.AuthDto;

public interface RegistrationFacade {

    void registration(AuthDto dto);
}
