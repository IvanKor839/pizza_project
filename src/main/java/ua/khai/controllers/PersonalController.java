package ua.khai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.khai.validated.ValidId;

@Validated
@Controller
@RequestMapping("/personal/dashboard")
public class PersonalController {

    @GetMapping()
    public String dashboard() {
        return "pages/personal/dashboard";
    }
}
