package ua.khai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){return "redirect:/product";
    }
    /*@GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title","Xui");
        return "login1";
    }*/


}
