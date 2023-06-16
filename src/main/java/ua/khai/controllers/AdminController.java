package ua.khai.controllers;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.khai.dto.response.ProductResponseDto;
import ua.khai.facade.ProductFacade;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminController {

    @GetMapping
    public String dashboard() {
        return "pages/admin/dashboard";
    }

}
