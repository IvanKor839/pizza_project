package ua.khai.facade.impl;

import org.springframework.stereotype.Service;

import ua.khai.dto.request.register.AuthDto;
import ua.khai.entity.user.Personal;
import ua.khai.facade.RegistrationFacade;
import ua.khai.service.PersonalCrudService;

@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final PersonalCrudService personalService;

    public RegistrationFacadeImpl(PersonalCrudService personalService) {
        this.personalService = personalService;
    }

    @Override
    public void registration(AuthDto dto) {
        System.out.println("REgistration");
        Personal personal = new Personal();
        personal.setEmail(dto.getEmail());
        personal.setPassword(dto.getPassword());
        personalService.create(personal);
    }
}
