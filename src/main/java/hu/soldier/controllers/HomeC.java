package hu.soldier.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeC {


    @GetMapping("/")
    public String home(){
        return "index";
    }
}
